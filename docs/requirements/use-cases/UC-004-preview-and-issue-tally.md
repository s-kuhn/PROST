---
id: UC-004
title: Preview And Issue Tally
status: draft
source: Product-owner interview on 2026-07-26
---

# UC-004: Preview And Issue Tally

## Goal

An Organization Manager produces the A3 landscape PDF that Consumers will mark at the shared
location.

## Primary Actor

Organization Manager

## Preconditions

- No Tally is Issued or in Settlement Draft.
- At least one Active Consumer and one Active Product exist.

## Main Flow

1. The manager opens Tally preparation.
2. PROST uses the Organization title, instruction text, contact text, current Active Consumers, and
   current Active Products.
3. PROST renders a nonbinding preview.
4. The preview shows Tally Names, Product names and prices, relative-width columns, wrapped headers,
   repeated headings on vertical pages, and blank rows filling the remaining final page.
5. The manager resolves any legibility validation and confirms issuance.
6. PROST atomically creates the immutable Tally Snapshot and final PDF.
7. PROST records the issue timestamp and makes the Tally Issued.
8. The manager downloads and prints the PDF.

## Alternatives

- Preview may be repeated without creating a Tally.
- The final PDF may be downloaded again without creating a replacement.
- If all Products cannot remain legible on A3, issuance is blocked with actionable validation.

## Business Rules

- [BR-001](../business-rules/BR-001-consumer-lifecycle.md)
- [BR-002](../business-rules/BR-002-tally-lifecycle.md)
- [BR-003](../business-rules/BR-003-product-pricing.md)
- [BR-006](../business-rules/BR-006-product-lifecycle.md)

## Quality Scenarios

- `QS-USA-004`

## Acceptance Criteria

1. Preview has no persistent financial or lifecycle effect.
2. Confirmation stores exactly what the final PDF displays.
3. All pages repeat Consumer and Product headings and keep all Product columns together.
4. Email addresses and balances never appear in the PDF.
5. A Tally cannot be issued while another Tally is Issued or in Settlement Draft.

## Open Questions

- Must the PDF contain a human-readable Tally identifier on every page?
- Should the final PDF be stored as an artifact or reproducibly generated from the snapshot?
- See `OQ-003` and `OQ-008` in the [Open Question Register](../open-questions.md).
