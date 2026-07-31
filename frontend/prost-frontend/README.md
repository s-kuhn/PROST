# PROST Frontend

This directory contains the Angular frontend technical prototype for PROST. The prototype explores
routing, runtime configuration, Keycloak integration, and communication with the backend. It is not
an accepted product architecture or a source of business requirements.

See the [current technical state](../../docs/architecture/current-state.md) for known limitations and
the [requirements index](../../docs/requirements/README.md) for authoritative product requirements.

## Local Development

Install the locked dependencies:

```bash
npm ci
```

Start the frontend with its local configuration:

```bash
npm run start:local
```

The development server is available at <http://localhost:4200/>. Features that call the API or use
authentication also require the backend at `http://localhost:8080/prost/api` and Keycloak at
`http://localhost:8081`.

## Runtime Configuration

At startup, the application loads `/assets/config.json`. The checked-in local configuration is
[`src/assets/config.json`](src/assets/config.json). The container entrypoint generates this file from
deployment environment variables when the frontend image starts.

The runtime configuration contains:

- the PROST API URL;
- the public Keycloak URL;
- the Keycloak realm;
- the frontend client ID.

## Verification

Run the frontend checks with:

```bash
npm run lint
npm run test:ci
npm run build:prod
```

The repository's current verification baseline and known test gaps are documented in the
[current technical state](../../docs/architecture/current-state.md#verification-baseline).

## Licensing

This documentation is licensed under
[CC-BY-SA-4.0](../../LICENSES/CC-BY-SA-4.0.txt). Software and third-party files in this directory may
have different licenses; consult the repository's
[licensing policy](../../docs/governance/licensing.md) and `REUSE.toml` for file-level classification.
