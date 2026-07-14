#!/bin/sh

# Set default values if not provided
export FRONTEND_HOSTNAME=${FRONTEND_HOSTNAME:-localhost:80}
export PROST_API_URL=${PROST_API_URL:-/prost/api}
export KEYCLOAK_PUBLIC_URL=${KEYCLOAK_PUBLIC_URL:-http://localhost:8081}
export KEYCLOAK_REALM=${KEYCLOAK_REALM:-prost}
export KEYCLOAK_FRONTEND_CLIENT_ID=${KEYCLOAK_FRONTEND_CLIENT_ID:-prost-frontend}

# Generate nginx.conf from template
envsubst '${FRONTEND_HOSTNAME}' < /etc/nginx/nginx.conf.template > /etc/nginx/nginx.conf

cat > /usr/share/nginx/html/assets/config.json <<EOF
{
  "apiUrl": "${PROST_API_URL}",
  "keycloak": {
    "url": "${KEYCLOAK_PUBLIC_URL}",
    "realm": "${KEYCLOAK_REALM}",
    "clientId": "${KEYCLOAK_FRONTEND_CLIENT_ID}"
  }
}
EOF

echo "Generated nginx.conf with:"
echo "  FRONTEND_HOSTNAME=${FRONTEND_HOSTNAME}"
echo "Generated runtime config with:"
echo "  PROST_API_URL=${PROST_API_URL}"
echo "  KEYCLOAK_PUBLIC_URL=${KEYCLOAK_PUBLIC_URL}"

# Start nginx
nginx -g "daemon off;"
