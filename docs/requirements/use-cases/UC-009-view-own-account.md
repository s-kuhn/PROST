---
id: UC-009
title: View Own Account
status: draft
source: Product-owner interview on 2026-07-26
---

# UC-009: View Own Account

## Goal

A Consumer understands their current financial position and how it was derived.

## Primary Actor

Consumer

## Preconditions

- The Consumer is authenticated and has a PROST profile in any participation state.

## Main Flow

1. The Consumer opens their account.
2. PROST shows current balance and whether it represents credit or debt.
3. PROST shows participation state and any debt suspension.
4. PROST shows dated, itemized Consumption Charges, Deposits, Refunds, and Adjustments.
5. Consumption entries show Product, quantity, printed unit price, and total.
6. Corrected entries expose original and current itemization, reason, timestamp, and responsible
   manager.
7. If configured, PROST shows the Organization's payment label and external HTTPS link.

## Business Rules

- [BR-004](../business-rules/BR-004-settlement-and-corrections.md)
- [BR-005](../business-rules/BR-005-balance-and-suspension.md)
- [BR-007](../business-rules/BR-007-privacy-and-pseudonymization.md)

## Quality Scenarios

- `QS-COR-002`
- `QS-SEC-001`
- `QS-USA-001`
- `QS-USA-003`

## Acceptance Criteria

1. A Consumer cannot access another Consumer's account through UI or API manipulation.
2. The displayed balance equals the exact sum of visible effective entries.
3. Itemized quantities and unit prices match the relevant Settlement revision.
4. The view works on supported mobile and desktop browsers.
5. Pending, Suspended, and Inactive Consumers retain access.

## Open Questions

- Is pagination required for long transaction histories in the MVP?
- Should Consumers be able to download a personal statement after the MVP?
