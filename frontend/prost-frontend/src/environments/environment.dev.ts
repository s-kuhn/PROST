// Environment for dev stage (container deployment)
export const environment = {
  production: false,
  keycloak: {
    uri: 'https://keycloak.dev.prost.home.s-kuhn.de', // Switch to 'http://localhost:8081' for locally starting the dev environment
    realm: 'prost',
    clientId: 'prost-frontend',
  },
  apiUrl: 'http://backend:8080/prost/api',
};
