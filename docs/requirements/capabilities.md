---
title: Business Capabilities
status: draft
source: Product-owner interview on 2026-07-26 and initial PROST README
---

# Business Capabilities

| ID        | Capability                                       | MVP             | Related Requirements Or Notes                                                                                                                                       |
|-----------|--------------------------------------------------|-----------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `CAP-001` | Consumer onboarding and participation            | Yes             | [UC-001](use-cases/UC-001-register-consumer.md), [UC-002](use-cases/UC-002-manage-consumer-status.md), [UC-012](use-cases/UC-012-close-and-pseudonymize-account.md) |
| `CAP-002` | Product catalog and print layout                 | Yes             | [UC-003](use-cases/UC-003-manage-products.md)                                                                                                                       |
| `CAP-003` | Paper Tally lifecycle                            | Yes             | [UC-004](use-cases/UC-004-preview-and-issue-tally.md), [UC-005](use-cases/UC-005-cancel-and-replace-tally.md)                                                       |
| `CAP-004` | Consumption Settlement                           | Yes             | [UC-006](use-cases/UC-006-settle-tally.md), [UC-007](use-cases/UC-007-correct-settlement.md)                                                                        |
| `CAP-005` | Consumer account management                      | Yes             | [UC-008](use-cases/UC-008-record-account-transaction.md), [UC-009](use-cases/UC-009-view-own-account.md)                                                            |
| `CAP-006` | Organization administration                      | Yes             | [UC-010](use-cases/UC-010-manage-organization.md)                                                                                                                   |
| `CAP-007` | Financial oversight                              | Yes, anonymized | [UC-011](use-cases/UC-011-view-financial-aggregates.md)                                                                                                             |
| `CAP-008` | Organizational Units and coordinated procurement | No, future      | Change scenario `QS-MNT-001`                                                                                                                                        |
| `CAP-009` | Inventory, supplier, and invoice management      | No, future      | Initial README candidate includes entering supplier invoices; requirements not specified                                                                            |
| `CAP-010` | Scan-assisted mark recognition                   | No, future      | Not specified; human confirmation would remain mandatory                                                                                                            |
| `CAP-011` | Proactive debt warning before suspension         | No, future      | Candidate extension to `BR-005`                                                                                                                                     |
| `CAP-012` | Organization balance tracking                    | No, future      | Initial README candidate based on Consumer Deposits and supplier invoices; requirements not specified                                                               |
| `CAP-013` | Internal sales price calculation                 | No, future      | Initial README candidate; requirements not specified                                                                                                                |
| `CAP-014` | External sales price calculation                 | No, future      | Initial README candidate; requirements not specified                                                                                                                |
| `CAP-015` | Inter-organization goods exchange calculation    | No, future      | Initial README candidate; requirements not specified                                                                                                                |
| `CAP-016` | Operational reporting                            | No, future      | Initial README candidate for sales by day, week, month, or year and bottle-loss reporting; requirements not specified                                               |

Capabilities describe product outcomes, not software modules. Architecture boundaries will be
decided only after the supporting requirements are accepted.

The future capabilities originating from the initial PROST README are research candidates only.
Their actors, outcomes, accounting rules, terminology, and scope require elicitation before they can
become use cases or business rules.
