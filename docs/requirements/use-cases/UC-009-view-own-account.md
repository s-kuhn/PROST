---
id: UC-009
title: View Own Account
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
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

- [QS-COR-002](../quality-scenarios/QS-COR-002-exact-balance.md)
- [QS-SEC-001](../quality-scenarios/QS-SEC-001-consumer-isolation.md)
- [QS-USA-001](../quality-scenarios/QS-USA-001-consumer-device-and-language.md)
- [QS-USA-003](../quality-scenarios/QS-USA-003-accessibility-baseline.md)

## Acceptance Criteria

1. A Consumer cannot access another Consumer's account through UI or API manipulation.
2. The displayed balance equals the exact sum of visible effective entries.
3. Itemized quantities and unit prices match the relevant Settlement revision.
4. The view works on supported mobile and desktop browsers.
5. Pending, Suspended, and Inactive Consumers retain access.

## Open Questions

- See [OQ-023](../open-questions/OQ-023-transaction-history-pagination.md) for MVP
  transaction-history pagination.
- See [OQ-024](../open-questions/OQ-024-personal-statement.md) for a post-MVP personal statement
  download.
- See [OQ-009](../open-questions/OQ-009-browser-viewport-support.md) for supported browsers and
  viewport sizes.
