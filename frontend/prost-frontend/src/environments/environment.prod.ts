// Environment for production stage (container deployment)
export const environment = {
  production: true,
  keycloak: {
    uri: 'http://keycloak:8081',
    realm: 'prost',
    clientId: 'prost-frontend',
  },
  apiUrl: 'http://backend:8080/prost/api',
};
