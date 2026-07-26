---
id: UC-003
title: Manage Products
status: draft
source: Product-owner interview on 2026-07-26
---

# UC-003: Manage Products

## Goal

An Organization Manager maintains the consumable Products and their future printed layout.

## Primary Actor

Organization Manager

## Main Flow

1. The manager views active and inactive Products in print order.
2. The manager creates or edits a Product name, EUR price, active state, relative width weight, and
   position.
3. A new Product is appended by default; the manager may reorder Products explicitly.
4. PROST validates the values and displays which changes affect only the next Tally.
5. PROST saves the catalog change without altering any Issued Tally Snapshot.

## Alternatives

- A price change is rejected while a Tally is Issued or in Settlement Draft.
- An unused Product may be deleted after confirmation.
- A used Product may be deactivated but cannot be deleted.
- A deactivated Product may be reactivated and placed in the future print order.

## Business Rules

- [BR-003](../business-rules/BR-003-product-pricing.md)
- [BR-006](../business-rules/BR-006-product-lifecycle.md)

## Quality Scenarios

- `QS-COR-002`

## Acceptance Criteria

1. Product prices use exact EUR-cent values.
2. Print order is manager-defined and stable.
3. Width weights are positive and previewable.
4. Product changes made while a Tally is Issued or in Settlement Draft do not alter its Tally
   Snapshot.
5. Historical Settlements retain the Product name and price printed at issuance.
6. A negative Product price is rejected.

## Open Questions

- Are complimentary zero-price Products needed?
- What physical minimum width makes a Product column markable?
