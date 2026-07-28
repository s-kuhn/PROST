# Open Question Register

Status: active

These questions block acceptance of the linked requirements. They are not implementation choices
that an architect or developer may decide silently.

| ID       | Priority | Question                                                                                                                                                                             | Affected Artifacts                                   |
|----------|----------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------|
| `OQ-002` | High     | What cohort-size and differencing protections make Treasurer aggregates sufficiently anonymous?                                                                                      | `UC-011`, `BR-007`, `QS-SEC-005`                     |
| `OQ-003` | High     | After pseudonymization, are historical Tally Names redacted, replaced by an irreversible pseudonym, or retained under a documented basis? What happens to previously generated PDFs? | `UC-004`, `UC-012`, `BR-002`, `BR-007`, `QS-SEC-004` |
| `OQ-004` | High     | Which MFA factors, enrollment, recovery, replacement, authentication age, and OIDC assurance evidence are acceptable for privileged roles?                                           | `UC-010`, `QS-SEC-002`                               |
| `OQ-005` | High     | How are local and OIDC identities linked without duplicate Consumers or account takeover?                                                                                            | `UC-001`, identity ADR                               |
| `OQ-006` | Medium   | Which retention rules apply to financial audit history, pseudonymization, security logs, and backups?                                                                                | `BR-004`, `BR-007`, `QS-SEC-004`, `QS-OPS-003`       |
| `OQ-007` | Medium   | How must restoration handle privacy actions that occurred after an older backup was created?                                                                                         | `BR-007`, `QS-OPS-003`                               |
| `OQ-009` | Medium   | Which browser versions and viewport sizes are supported?                                                                                                                             | `UC-009`, `QS-USA-001`                               |
| `OQ-010` | Medium   | What duration expires a Settlement Draft edit lock?                                                                                                                                  | `BR-002`, `BR-004`, `UC-006`                         |
| `OQ-011` | Low      | Is the software license `AGPL-3.0-only` or `AGPL-3.0-or-later`, and who owns copyright?                                                                                              | Arc42 section 2, release governance                  |
| `OQ-012` | High     | How is the first Organization Manager established securely without allowing an untrusted registrant to claim the Organization?                                                        | `BR-001`, `UC-010`, identity ADR                     |
| `OQ-013` | Medium   | Which Organization settings may change while a Tally is Issued or in Settlement Draft, and when do those changes take effect?                                                         | `UC-010`, `BR-002`, `BR-003`                         |

Resolved questions should be removed from this register only after their outcome is represented in
the affected requirements and reviewed for consistency.
