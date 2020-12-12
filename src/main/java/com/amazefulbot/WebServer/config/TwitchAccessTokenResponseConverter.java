//package com.amazefulbot.WebServer.config;
//
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.security.oauth2.core.OAuth2AccessToken;
//import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
//import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
//import org.springframework.util.StringUtils;
//
//import java.util.*;
//
//public final class TwitchAccessTokenResponseConverter
//        implements Converter<Map<String, String>, OAuth2AccessTokenResponse> {
//
//    public static final String OAUTH2_SPEC_SCOPE_DELIMITER = " ";
//    public static final String OAUTH2_TWITCH_SCOPE_DELIMITER = ", ";
//    private static final Set<String> TOKEN_RESPONSE_PARAMETER_NAMES = new HashSet<>(Arrays.asList(
//            OAuth2ParameterNames.ACCESS_TOKEN,
//            OAuth2ParameterNames.EXPIRES_IN,
//            OAuth2ParameterNames.REFRESH_TOKEN,
//            OAuth2ParameterNames.SCOPE,
//            OAuth2ParameterNames.TOKEN_TYPE
//    ));
//
//    public static Set<String> delimitedListToStringSet(
//            String scope,
//            String delimiter
//    ) {
//        return new HashSet<>(
//                Arrays.asList(
//                        StringUtils.delimitedListToStringArray(
//                                scope,
//                                delimiter
//                        )
//                )
//        );
//    }
//
//    /**
//     * Parses an OAuth 2.0 scope which is formatted according to the
//     * <a href="https://tools.ietf.org/html/rfc6749#section-3.3">OAuth 2.0
//     * specification</a>
//     *
//     * @param scope The scope string.
//     * @return The parsed set of scopes.
//     */
//    public static Set<String> parseSpecOAuth2Scope(String scope) {
//        return delimitedListToStringSet(scope, OAUTH2_SPEC_SCOPE_DELIMITER);
//    }
//
//    /**
//     * Parses an OAuth 2.0 scope which is formatted according to
//     * <a href="https://dev.twitch.tv/docs/authentication/getting-tokens-oauth">
//     * Twitch's OAuth 2.0 implementation</a>.
//     *
//     * @param scope The scope string.
//     * @return The parsed set of scopes.
//     */
//    public static Set<String> parseTwitchOAuth2Scope(String scope) {
//        return delimitedListToStringSet(
//                // Remove the '[' and ']' characters from the scope String.
//                scope.substring(1, scope.length() - 1),
//                OAUTH2_TWITCH_SCOPE_DELIMITER
//        );
//    }
//
//    /**
//     * Parses an OAuth 2.0 scope either according to the specification or to
//     * Twitch's implementation.
//     *
//     * @param scope The scope string.
//     * @return The parsed set of scopes.
//     */
//    public static Set<String> parseOAuth2Scope(String scope) {
//        if (scope.startsWith("[") && scope.endsWith("]")) {
//            return parseTwitchOAuth2Scope(scope);
//        } else {
//            return parseSpecOAuth2Scope(scope);
//        }
//    }
//
//    @Override
//    public OAuth2AccessTokenResponse convert(Map<String, String> tokenResponseParameters) {
//        String accessToken = tokenResponseParameters.get(OAuth2ParameterNames.ACCESS_TOKEN);
//
//        OAuth2AccessToken.TokenType accessTokenType = null;
//        if (OAuth2AccessToken.TokenType.BEARER.getValue().equalsIgnoreCase(
//                tokenResponseParameters.get(OAuth2ParameterNames.TOKEN_TYPE))) {
//            accessTokenType = OAuth2AccessToken.TokenType.BEARER;
//        }
//
//        long expiresIn = 0;
//        if (tokenResponseParameters.containsKey(OAuth2ParameterNames.EXPIRES_IN)) {
//            try {
//                expiresIn = Long.parseLong(tokenResponseParameters.get(OAuth2ParameterNames.EXPIRES_IN));
//            } catch (NumberFormatException ex) {
//            }
//        }
//        tokenResponseParameters.forEach((key, value) -> System.out.println(key + ":" + value));
//
//        Set<String> scopes = Optional
//                .ofNullable(tokenResponseParameters.get(OAuth2ParameterNames.SCOPE))
//                .map(TwitchAccessTokenResponseConverter::parseOAuth2Scope)
//                .orElse(Collections.emptySet());
//
//        String refreshToken = tokenResponseParameters.get(OAuth2ParameterNames.REFRESH_TOKEN);
//
//        Map<String, Object> additionalParameters = new LinkedHashMap<>();
//        for (Map.Entry<String, String> entry : tokenResponseParameters.entrySet()) {
//            if (!TOKEN_RESPONSE_PARAMETER_NAMES.contains(entry.getKey())) {
//                additionalParameters.put(entry.getKey(), entry.getValue());
//            }
//        }
//
//
//        additionalParameters.put("Client-ID", "xml9n4468f401hn9r4u7ce355p12fo");
//        return OAuth2AccessTokenResponse.withToken(accessToken)
//                .tokenType(accessTokenType)
//                .expiresIn(expiresIn)
//                .scopes(scopes)
//                .refreshToken(refreshToken)
//                .additionalParameters(additionalParameters)
//                .build();
//    }
//}