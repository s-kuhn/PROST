---
id: BR-003
title: Product Pricing
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
source: Product-owner interviews on 2026-07-26 and 2026-07-29
---

# BR-003: Product Pricing

## Rules

1. Every active Product has a nonnegative EUR price with cent precision. Whether zero is permitted
   remains open through [OQ-020](../open-questions/OQ-020-zero-price-products.md); a negative Product
   price is invalid.
2. The price stored in the issued Tally Snapshot is the price charged for marks on that Tally.
3. A Product price cannot change while a Tally is Issued or in Settlement Draft.
4. Settling or cancelling the current Tally permits a price change before the next Tally is issued.
5. Product display name, active state, print position, and relative column-width-weight changes may
   be saved while a Tally is Issued or in Settlement Draft. They become current immediately, do not
   alter that Tally Snapshot or final PDF, and first appear in the next Tally preview.
6. Historical Product names and prices in Tally Snapshots are immutable.
7. Correcting a Settlement may change counts and Consumer mappings but cannot change the printed
   Product or price snapshot.

## Rationale

The physical sheet communicates a price to Consumers. Charging a later price would make existing
marks ambiguous and could silently change debt.

## Open Questions

- See [OQ-020](../open-questions/OQ-020-zero-price-products.md) for complimentary zero-price
  Products.
- See [OQ-032](../open-questions/OQ-032-product-taxation.md) for taxation and Product-price semantics.
- See the resolved [OQ-013](../open-questions/OQ-013-settings-effective-time.md) for settings
  effective-time traceability.
