package com.amazefulbot.WebServer.config;

import com.amazefulbot.WebServer.models.User;
import com.amazefulbot.WebServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Optional;

@Service
public class TwitchUserService extends DefaultOAuth2UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        try {
            return processTwitchUser(oAuth2UserRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User processTwitchUser(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        TwitchOAuth2UserInfo oAuth2UserInfo = new TwitchOAuth2UserInfo(oAuth2User.getAttributes());
        HelixUsers helixUsers = getHelixUser(oAuth2UserInfo.getClientId(), oAuth2UserRequest.getAccessToken().getTokenValue());
        HelixUser helixUser = helixUsers.getUser();

        if(StringUtils.isEmpty(oAuth2UserInfo.getId()) ) {
            throw new AuthenticationProcessingException("id not found from OAuth2 provider");
        }

        Optional<User> userOptional = userRepository.findById(Integer.parseInt(oAuth2UserInfo.getId()));
        User user;
        if(userOptional.isPresent()) {
            user = userOptional.get();
            user = updateUser(user, helixUser);
        } else {
            user = registerUser(helixUser);
        }
        return UserPrincipal.create(user, oAuth2User.getAttributes());
    }

    private User registerUser(HelixUser helixUser) {
        User user = new User();
        user.setId(helixUser.getId());
        user.setLogin(helixUser.getLogin());
        user.setType(helixUser.getType());
        user.setProfile_image_url(helixUser.getProfile_image_url());
        user.setDisplay_name(helixUser.getDisplay_name());
        user.setBroadcaster_type(helixUser.getBroadcaster_type());
        return userRepository.save(user);
    }

    private User updateUser(User existingUser, HelixUser helixUser) {

        existingUser.setDisplay_name(helixUser.getDisplay_name());
        existingUser.setLogin(helixUser.getLogin());
        existingUser.setType(helixUser.getType());
        existingUser.setBroadcaster_type(helixUser.getBroadcaster_type());
        existingUser.setProfile_image_url(helixUser.getProfile_image_url());
        return userRepository.save(existingUser);
    }

    private HelixUsers getHelixUser(String clientId, String  accessToken){

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.twitch.tv/helix/users";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("authorization", "Bearer " + accessToken);
        headers.set("Client-ID", clientId);
        HttpEntity request = new HttpEntity(headers);
;
        ResponseEntity<HelixUsers> response = restTemplate.exchange(url, HttpMethod.GET, request, HelixUsers.class);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new AuthenticationProcessingException("Could not get HelixUser");
        }
    }

}