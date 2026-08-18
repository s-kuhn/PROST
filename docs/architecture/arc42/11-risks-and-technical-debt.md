# 11. Risks And Technical Debt

Documentation coverage: partial

## Product And Domain Risks

| ID         | Risk                                                            | Impact                                                                    | Current Mitigation                                                                                                                                                                                                                                                                                                            |
|------------|-----------------------------------------------------------------|---------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `RISK-001` | No committed pilot validates the elicited workflow.             | Requirements may reflect one past Organization rather than current users. | Keep assumptions explicit and seek pilot review before production acceptance.                                                                                                                                                                                                                                                 |
| `RISK-002` | Physical marks are unreadable, dishonest, damaged, or lost.     | Consumption cannot be attributed or recovered digitally.                  | Support Unallocated Consumption, audited cancellation, and explicit human responsibility; do not invent charges.                                                                                                                                                                                                              |
| `RISK-003` | Broad Organization Manager powers include self-account changes. | Error or abuse can affect financial balances.                             | Accepted [BR-005](../../requirements/business-rules/BR-005-balance-and-suspension.md) permits and highlights self-account entries in audit views. No accepted use case currently requires second-person approval; define that control only if a future use case demonstrates the need. Residual error and abuse risk remains. |
| `RISK-004` | Public Tally Names expose participation in a physical location. | Privacy expectations may be violated.                                     | Consumer-selected Tally Name, onboarding notice, and no printed email or balance.                                                                                                                                                                                                                                             |

## Architecture And Security Risks

| ID         | Risk                                                                                                           | Impact                                                                                   | Required Treatment                                                                                                                                                                                                                                                                                                                          |
|------------|----------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `RISK-005` | Local accounts, optional OIDC, verified email, recovery, and privileged MFA create complex identity semantics. | Account takeover, duplicate Consumer profiles, or operational burden.                    | Threat model and identity ADR before implementation.                                                                                                                                                                                                                                                                                        |
| `RISK-006` | Private HTTP exposes credentials and financial data.                                                           | Network interception and reduced browser security.                                       | Explicit insecure mode, warnings, public prohibition, and documented operator responsibility.                                                                                                                                                                                                                                               |
| `RISK-007` | Deployment Operator can access databases, secrets, and backups.                                                | Application roles cannot fully isolate personal data from infrastructure administrators. | Document trust boundary, least privilege, secure backups, and audit operational access where feasible.                                                                                                                                                                                                                                      |
| `RISK-008` | Editable financial workflows conflict with audit integrity.                                                    | Silent history changes or incorrect balances.                                            | Define and accept the revision model, atomic deltas, immutable evidence, and high-level tests before implementation.                                                                                                                                                                                                                        |
| `RISK-009` | Pseudonymization conflicts with audit, identity, retention, historical Tallies, and backups.                   | Incomplete erasure, restored login access, or broken historical consistency.             | Resolve [OQ-003](../../requirements/open-questions/OQ-003-pseudonymized-tally-names.md), [OQ-006](../../requirements/open-questions/OQ-006-retention-rules.md), and [OQ-007](../../requirements/open-questions/OQ-007-restore-after-privacy-actions.md) and verify the resulting pseudonymization and restore design before implementation. |

## Operability Risks

| ID         | Risk                                                                                                       | Impact                                                       | Required Treatment                                                                                                                                                                                |
|------------|------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `RISK-010` | Identity, SMTP, URLs, TLS, and redirect configuration may exceed volunteer skills.                         | Failed or insecure installations.                            | Compare simpler architectures, provide diagnostics, and measure the adjustable installation target with a pilot.                                                                                  |
| `RISK-011` | Supporting bundled HTTPS, external proxies, public access, and private HTTP expands the deployment matrix. | Test and documentation burden.                               | Define supported combinations and automated smoke tests in the deployment ADR.                                                                                                                    |
| `RISK-012` | Operator-selected backup policy can be absent, insecure, or untested.                                      | Unbounded data loss or disclosure despite a restore command. | Classify artifacts as sensitive, validate integrity, provide recommended protection and schedules, and require a restore rehearsal even though destination and retention remain operator choices. |

## Prototype Technical Debt

- Demo OpenAPI operations and frontend Books contract disagree.
- Prototype role names and authorization behavior are inconsistent.
- Keycloak synchronization is a demo ping rather than a reliable contract.
- Application and Keycloak database configuration is coupled.
- CI skips backend tests and disables frontend tests.
- No accepted module boundaries, security tests, contract tests, or migration protection exist.
- Dependency and product versions drift across files.
- Maven wrapper execution and test-environment setup are unreliable.

See [Current Technical State](../current-state.md) for details.

## Governance Risks

- Repository license artifacts and file-level metadata can drift from the
  [licensing policy](../../governance/licensing.md); verification required by
  [Release Governance](../../governance/release-governance.md) must detect inconsistencies.
- Future Organizational Units could force broad rework if MVP boundaries assume all data is globally
  owned.
- Architecture chapters could drift toward the prototype before requirements and ADRs are accepted.
