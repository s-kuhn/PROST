// Environment for dev stage (container deployment)
export const environment = {
  production: false,
  keycloak: {
    uri: 'http://keycloak:8081', // Switch to localhost for locally starting the dev environment
    realm: 'prost',
    clientId: 'prost-frontend',
  },
  apiUrl: 'http://backend:8080/prost/api',
};
