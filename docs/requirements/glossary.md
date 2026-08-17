---
title: Glossary
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-applicable
source: Existing Arc42 glossary migrated on 2026-08-17
---

# Glossary

This controlled artifact defines the working Ubiquitous Language for requirements and architecture.
Draft terms guide current specification work but become normative only in an accepted revision.

| Term                    | Definition                                                                                                                                                                                                                                                                                           |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Account Transaction     | A balance-affecting record for one Consumer, such as a Consumption Charge, Deposit, Refund, or Adjustment.                                                                                                                                                                                           |
| Active                  | Consumer state eligible for inclusion on newly issued Tallies.                                                                                                                                                                                                                                       |
| Adjustment              | A justified manual balance change that is neither Consumption, Deposit, nor Refund.                                                                                                                                                                                                                  |
| Audit Trail             | Preserved evidence of actor, time, reason, original value, and revised value for a privileged action.                                                                                                                                                                                                |
| Consumer                | A person with a PROST profile whose consumption and money entries determine a personal balance. Replaces the legacy term “Drinker.”                                                                                                                                                                  |
| Consumption Charge      | A negative Account Transaction derived from itemized Product counts in a Settlement.                                                                                                                                                                                                                 |
| Deposit                 | Money received from a Consumer and credited to their account.                                                                                                                                                                                                                                        |
| Deployment Operator     | Technically privileged person responsible for installation, initial Organization Manager bootstrap, URLs, TLS, SMTP, identity integration, secrets, backup, restore, and upgrades.                                                                                                                   |
| Inactive                | Manually excluded Consumer state that retains account access and history.                                                                                                                                                                                                                            |
| Organization            | The single volunteer organization served by one MVP deployment.                                                                                                                                                                                                                                      |
| Organizational Unit     | A future subdivision of an Organization, such as a chapter, department, committee, or local group. Not an MVP entity.                                                                                                                                                                                |
| Organization Manager    | Privileged application role managing Consumers, Products, Tallies, Settlements, money entries, settings, and roles.                                                                                                                                                                                  |
| Payment Link            | Optional Organization-configured label and external HTTPS URL. It does not confirm or create a Deposit automatically.                                                                                                                                                                                |
| Pending Approval        | Consumer state after verified registration and profile completion but before participation is approved through an authorized workflow.                                                                                                                                                               |
| Product                 | A consumable item represented by a column on a Tally and charged at its printed EUR price.                                                                                                                                                                                                           |
| PROST                   | Product name formed from Planning, Reporting, Ordering, Stock, and Tally. The expansion reflects the broader product vision and does not imply that every named capability is included in the MVP.                                                                                                   |
| Pseudonymized           | Terminal Consumer state after login and direct profile identifiers have been irreversibly removed or unlinked.                                                                                                                                                                                       |
| Refund                  | Money returned to a Consumer and debited from their account.                                                                                                                                                                                                                                         |
| Settlement              | The confirmed transcription of Product counts from one physical Tally and its resulting account effects.                                                                                                                                                                                             |
| Settlement Draft        | Saved, editable transcription that has not affected balances.                                                                                                                                                                                                                                        |
| Suspended               | Automatically excluded Consumer state caused by reaching the configured debt threshold.                                                                                                                                                                                                              |
| Tally                   | The business document represented by one issued physical paper sheet or set of vertically paginated sheets and its lifecycle.                                                                                                                                                                        |
| Tally Name              | Organization-unique, Consumer-chosen identifier that becomes approved when Consumer participation is approved through an authorized workflow and is printed publicly on a Tally. It is not an identity-provider username.                                                                            |
| Tally Snapshot          | Immutable record of Organization text, registration and optional payment destinations, QR-code content and placement, Consumer rows, Product display names, prices, ordering, widths, layout profile, printed generation time, and internal issue time for a Tally. It contains no individual marks. |
| Treasurer               | MFA-protected read-only role that sees anonymized Organization-level financial and consumption aggregates.                                                                                                                                                                                           |
| Unallocated Consumption | Product counts transcribed from a handwritten row that cannot be attributed to a registered Consumer; it creates no Consumer charge.                                                                                                                                                                 |

## Terminology Rules

- Use `Consumer`, not `Drinker`, outside legacy references.
- Use `Organization`, not institution-specific terms such as AStA or Student Council.
- Use `Organizational Unit` only for the future capability until accepted requirements define it.
- Do not use `balance sheet` for a Consumer account; that term has a different accounting meaning.
