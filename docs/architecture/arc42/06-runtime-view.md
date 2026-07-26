# 6. Runtime View

Status: not decided

Runtime views will be added after building blocks and contracts are proposed. Mermaid sequence
diagrams should focus on architecture-relevant scenarios rather than duplicating every use-case
step.

## Required Scenarios

- Registration, verified identity, PROST profile creation, and manager approval.
- Tally preview and atomic issuance.
- Settlement Draft locking, preview, and exactly-once posting.
- Audited Settlement correction and Consumer-visible revision.
- Deposit recording with debt suspension or reactivation.
- MFA-protected privileged access.
- Backup and clean-host restore.
- Identity, SMTP, or payment-link failure behavior.

Each runtime scenario must link to accepted `UC`, `BR`, `QS`, and relevant `ADR` identifiers.
