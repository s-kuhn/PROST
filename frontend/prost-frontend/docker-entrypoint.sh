#!/bin/sh

# Set default values if not provided
export FRONTEND_HOSTNAME=${FRONTEND_HOSTNAME:-localhost:80}

# Generate nginx.conf from template
envsubst '${FRONTEND_HOSTNAME}' < /etc/nginx/nginx.conf.template > /etc/nginx/nginx.conf

echo "Generated nginx.conf with:"
echo "  FRONTEND_HOSTNAME=${FRONTEND_HOSTNAME}"
echo "Environment variables replaced in Angular build"

# Start nginx
nginx -g "daemon off;"
