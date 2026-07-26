---
id: BR-003
title: Product Pricing
status: draft
source: Product-owner interview on 2026-07-26
---

# BR-003: Product Pricing

## Rules

1. Every active Product has a nonnegative EUR price with cent precision. Whether zero is permitted
   remains open; a negative Product price is invalid.
2. The price stored in the issued Tally Snapshot is the price charged for marks on that Tally.
3. A Product price cannot change while a Tally is Issued or in Settlement Draft.
4. Settling or cancelling the current Tally permits a price change before the next Tally is issued.
5. Product name, active state, display order, and width-weight changes made while a Tally is open
   affect only the next Tally.
6. Historical Product names and prices in Tally Snapshots are immutable.
7. Correcting a Settlement may change counts and Consumer mappings but cannot change the printed
   Product or price snapshot.

## Rationale

The physical sheet communicates a price to Consumers. Charging a later price would make existing
marks ambiguous and could silently change debt.

## Open Questions

- Is a zero-priced Product valid for complimentary items, or must every active Product have a
  positive price?
- Are prices tax-inclusive by definition, or is taxation outside the product scope?
