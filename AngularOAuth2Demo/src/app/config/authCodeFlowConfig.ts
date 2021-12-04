import { AuthConfig } from "angular-oauth2-oidc";

// If you are using okta as authorization server
// it will be https://<Your Okta Domain>/oauth2/default
const ISSUER: string = "https://dev-20751509.okta.com/oauth2/default";

export const authCodeFlowConfig: AuthConfig = {
  issuer: ISSUER,
  redirectUri: window.location.origin,
  clientId: "0oa2xnabuyoTLhTsI5d7",
  responseType: "code",
  scope: "openid profile email",
  showDebugInformation: true
};
