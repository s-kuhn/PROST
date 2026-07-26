---
id: BR-007
title: Privacy And Pseudonymization
status: draft
source: Product-owner interview on 2026-07-26
---

# BR-007: Privacy And Pseudonymization

## Access Rules

1. A Consumer may access only their own profile, balance, itemized transactions, and relevant
   correction history.
2. Organization Managers may access identifiable Consumer data required for onboarding, Tally
   operation, account management, and audit.
3. Treasurers may access only aggregate financial and consumption information permitted by the
   accepted cohort and differencing policy. Until `OQ-002` is resolved, this access is not
   acceptance-ready.
4. Deployment Operators are trusted infrastructure administrators and may technically access
   databases, backups, and secrets even without an application role.
5. Tally Names are intentionally printed in a physically public location; the onboarding flow must
   explain this use.
6. Email addresses, balances, and transaction amounts are never printed on the Tally.

## Closure And Pseudonymization

1. A Consumer may end active participation at any time and retain access while debt or credit
   remains.
2. An Inactive, zero-balance Consumer may request irreversible pseudonymization.
3. Pseudonymization removes or unlinks login and direct profile identifiers while preserving
   non-identifying financial and audit records.
4. Backup copies may retain pre-pseudonymization data until normal operator-defined backup rotation
   removes them; this limitation must be disclosed.
5. A later registration after pseudonymization creates a new Consumer identity.
6. Pseudonymization is blocked while the Consumer holds Organization Manager or Treasurer roles. An
   existing Organization Manager must revoke those roles first, and the last Organization Manager
   must appoint a successor before revocation.
7. Historical Tally Snapshot and PDF treatment remains unresolved under `OQ-003`; this rule is not
   acceptance-ready until that conflict is resolved.
8. Successful pseudonymization changes the participation state from Inactive to Pseudonymized.

## Open Questions

- Which audit actor attributes remain after a former Organization Manager is pseudonymized?
- What legal or organization-defined retention period can delay pseudonymization?
- Is self-service data export required after the MVP?
- See `OQ-003`, `OQ-006`, and `OQ-007` in the [Open Question Register](../open-questions.md).
