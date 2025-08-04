// Environment for local development (IDE start)
export const environment = {
  production: false,
  keycloak: {
    uri: 'http://localhost:8081',
    realm: 'prost',
    clientId: 'prost-frontend',
  },
  apiUrl: 'http://localhost:8080/prost/api',
};
