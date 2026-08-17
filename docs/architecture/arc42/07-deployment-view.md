# 7. Deployment View

Documentation coverage: placeholder

No packaging, orchestration, network topology, identity deployment, database layout, or TLS
component is accepted.

## Required Deployment Variants

- Public installation with HTTPS.
- Installation behind an operator-managed reverse proxy.
- Explicit private-network insecure HTTP mode.
- Local identity and optional external OIDC paths.
- Development environment isolated from production assumptions.

## Evaluation Criteria

- Reproducible installation without source edits.
- Adjustable approximate 60-minute setup target on a prepared host.
- Actionable health and configuration diagnostics.
- Secret isolation and rotation.
- Portable backup and same-day clean-host restoration.
- Upgrade and rollback behavior.
- Minimum CPU, memory, storage, and supported host architecture.

The existing Compose deployment is one candidate and is described
in [Current Technical State](../current-state.md).
