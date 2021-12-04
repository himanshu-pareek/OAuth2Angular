import { AuthConfig } from "angular-oauth2-oidc";

// If you are using okta as authorization server
// it will be https://<Your Okta Domain>/oauth2/default
const ISSUER: string = "<Your Issuer URI>";

export const authCodeFlowConfig: AuthConfig = {
  issuer: ISSUER,
  redirectUri: window.location.origin,
  clientId: "<Your Client Id>",
  responseType: "code",
  scope: "openid profile email",
  showDebugInformation: true
};
