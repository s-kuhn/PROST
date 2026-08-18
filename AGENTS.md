# PROST Agent Guidelines

PROST is being developed requirements-first. The repository currently contains a technical
prototype, not an accepted product architecture or a source of business requirements.

## Sources Of Truth

Resolve conflicts in this order:

1. Accepted governance policies in `docs/governance/` for process and project-wide constraints.
2. Accepted requirements in `docs/requirements/` for product behavior.
3. Accepted architecture decisions in `docs/architecture/decisions/`.
4. API, data, and external integration contracts.
5. Executable tests.
6. Implementation code.

Arc42 is a derived architecture view. It summarizes and links authoritative sources but does not
create product requirements or architecture decisions.

Stop and ask the product owner when two sources conflict. Never silently change a higher-level
source to fit a lower-level implementation.

## Development Gate

- Follow [Specification Governance](docs/governance/specification-governance.md) for artifact
  maturity, lifecycle, delivery, acceptance, and readiness.
- Do not change application behavior without a complete work-item gate declaration containing exact
  `UC`, `BR`, `QS`, `ADR`, `OQ`, acceptance-criterion, and quality-measure lists with revisions and
  verification seams, including explicit empty lists.
- Do not infer applicable requirements, quality scenarios, architecture decisions, or the absence of
  open questions from omitted information.
- Implement only when every listed requirement, quality scenario, and required ADR is accepted and
  active on `main`, and no applicable open question blocks the work.
- Only the human Product Owner may make acceptance, supersession, or withdrawal authoritative by the
  pull-request process. Agents may prepare proposals but may not perform the acceptance action or
  merge an acceptance pull request.
- Only the human Product Owner may answer, defer, supersede, reopen, resolve, or reduce the blocking
  scope of an Open Question authoritatively.
- Record unknowns as open questions. Do not turn assumptions into requirements.
- Treat legacy DrinkIt behavior and the existing PROST code as research input only.

Documentation and governance work may proceed before application implementation. During the current
requirements phase, keep target-architecture sections that are not decided explicit rather than
filling them from the prototype.

## Repository Map

```text
docs/requirements/                Detailed product requirements and business rules
docs/architecture/arc42/          Target architecture documentation
docs/architecture/decisions/      Architecture Decision Records
docs/architecture/current-state.md Technical prototype inventory
server/                            Kotlin/Spring backend prototype
frontend/prost-frontend/           Angular frontend prototype
keycloak-webhook-event-listener/   Kotlin Keycloak plugin prototype
docker/                            Local and deployment infrastructure
```

Dependency manifests are authoritative for tool and framework versions. Do not duplicate volatile
version numbers in guidance documents.

## Hard Invariants

- OpenAPI specifications under `server/api/` are the source for generated API code.
- Never edit generated files under `target/`, `dist/`, `.angular/`, or `node_modules/`.
- Never change, delete, or rename an existing versioned Flyway migration. Add a forward migration
  instead.
- Never read, edit, log, or commit secrets, tokens, credentials, `.env` files, or personal
  production data.
- Do not commit, push, tag, release, merge, or deploy unless the user explicitly requests it.
- Treat identity, authorization, financial balances, audit history, workflows, and deployment files
  as security-sensitive.
- Preserve unrelated worktree changes.

## Change Traceability

Application changes must reference applicable IDs in their task or change description:

- `UC-###` for use cases.
- `BR-###` for business rules.
- `QS-<category>-###` for quality scenarios.
- `ADR-####` for architecture decisions.

Tests should use the highest practical observable seam and demonstrate the linked acceptance
criteria.

## Verification

Run checks appropriate to changed paths. Do not claim success without fresh command output.

### Backend

Working directory: `server/`

```bash
./mvnw clean verify
./mvnw spotless:check
```

The wrapper is currently not executable in Git; use `mvn` only when the environment has a compatible
Maven installation, and record that exception.

### Frontend

Working directory: `frontend/prost-frontend/`

```bash
npm ci
npm run lint
npm run test:ci
npm run build:prod
```

### Keycloak Plugin

Working directory: `keycloak-webhook-event-listener/`

```bash
mvn -ntp clean verify
```

The current CI and test baseline is incomplete. A command listed here is an intended verification
command, not evidence that the existing prototype passes it.

## Documentation Conventions

- Write documentation and canonical domain terminology in English.
- Use Mermaid for diagrams.
- Use relative links within the repository.
- Keep controlled-artifact maturity, lifecycle, delivery, and revision metadata explicit.
- Keep each normative uncertainty in an individual `OQ-*` record and link to it rather than
  duplicating the question.
- Use the governed Specification Review Packet for Product Owner review and acceptance pull
  requests.
- Keep Arc42 requirement summaries concise and link to detailed requirements.
- Avoid duplicating business rules across files; reference their stable IDs.

## Escalation Conditions

Stop and ask before proceeding when:

- a requested change has no accepted requirement;
- a price, balance, settlement, audit, identity, or authorization invariant is unclear;
- an API change may be breaking;
- a migration would alter existing history;
- generated and source files disagree;
- a security-sensitive path must change outside the explicit task;
- verification cannot be run or produces contradictory results.
