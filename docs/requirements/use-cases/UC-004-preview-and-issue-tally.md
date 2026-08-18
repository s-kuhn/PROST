---
id: UC-004
title: Preview And Issue Tally
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
source: Product-owner interviews on 2026-07-26 and 2026-07-27
---

# UC-004: Preview And Issue Tally

## Goal

An Organization Manager produces the A3 landscape PDF that Consumers will mark at the shared
location.

## Primary Actor

Organization Manager

## Preconditions

- No Tally is Issued or in Settlement Draft.
- At least one Active Consumer exists.

## Main Flow

1. The manager opens Tally preparation.
2. PROST uses the Organization title, instruction text, contact text, current Active Consumers, and
   current active Products, generic registration destination, and optional payment-link label and
   destination.
3. PROST validates that between one and five Products are active and that their width weights are
   whole numbers from 1 through 5.
4. PROST renders a nonbinding preview with a fixed `Generated at` value.
5. The preview shows Tally Names, Product names and prices, relative-width columns, wrapped headers,
   automatic Product-header sizing from 12 pt down to 10 pt, repeated headings on vertical pages,
   blank rows filling the remaining final page, a registration QR code, and an optional payment QR
   code.
6. PROST applies the physical layout baseline
   in [BR-006](../business-rules/BR-006-product-lifecycle.md)
   and places each QR code in a dedicated informational area on the first page outside the Tally
   grid.
7. The manager resolves any validation and confirms that the preview provides practical marking
   space and scannable QR-code placement.
8. If any rendered input or the layout profile changed after preview, PROST rejects confirmation
   without creating a Tally and requires a new preview.
9. Otherwise, PROST atomically creates the immutable Tally Snapshot and final PDF from the confirmed
   preview inputs.
10. PROST records the internal `Issued at` timestamp and makes the Tally Issued. This internal value
    is not printed.
11. The manager downloads and prints the PDF.

## Alternatives

- Preview may be repeated without creating a Tally.
- The final PDF may be downloaded again without creating a replacement.
- If no Product is active, issuance is blocked with actionable validation.
- If more than five Products are active, issuance is blocked with actionable validation.
- If full Product names cannot fit at the 10 pt minimum header size without clipping or overlap,
  issuance is blocked with actionable validation.
- If a Product column would be narrower than 17 mm or the complete grid-heading row would exceed its
  25.5 mm maximum height, issuance is blocked with actionable validation.
- If a required registration QR code or configured payment QR code cannot be generated, issuance is
  blocked with actionable validation.
- If the exact payload returned by decoding a generated QR code exceeds 200 bytes, issuance is
  blocked with actionable validation.
- If all required QR codes, quiet zones, purpose labels, and human-readable destination hosts cannot
  fit in the dedicated first-page informational area without crossing a page margin or entering the
  Tally grid, preview and issuance are blocked with actionable validation.

## Business Rules

- [BR-001](../business-rules/BR-001-consumer-lifecycle.md)
- [BR-002](../business-rules/BR-002-tally-lifecycle.md)
- [BR-003](../business-rules/BR-003-product-pricing.md)
- [BR-006](../business-rules/BR-006-product-lifecycle.md)

## Quality Scenarios

- [QS-USA-004](../quality-scenarios/QS-USA-004-printable-tally-legibility.md)

## Acceptance Criteria

1. Preview has no persistent financial or lifecycle effect.
2. Confirmation stores every input and layout value needed to reproduce exactly what the final PDF
   displays.
3. All pages repeat Consumer and Product headings and keep all Product columns together.
4. Email addresses and balances never appear in the PDF.
5. A Tally cannot be issued while another Tally is Issued or in Settlement Draft.
6. Except for a preview-only indicator that does not affect layout, the preview and final PDF
   contain identical Organization text, Tally metadata, Consumer and blank rows, Product names and
   prices, line wrapping, widths, font sizes, QR codes, page breaks, repeated headings, and
   pagination.
7. The Organization Manager explicitly confirms that the preview provides practical marking space
   and scannable QR-code placement.
8. Confirmation based on changed Organization text, Consumer data, Product data, QR destination,
   layout configuration, or layout profile has no effect and requires a new preview.
9. The registration QR code contains only the generic registration URL and no personal data,
   one-time token, privileged invitation, or tracking value.
10. The payment QR code appears only when an Organization payment link is configured, contains that
    configured HTTPS URL, and has no automatic payment or Deposit effect.
11. Each QR code has a visible purpose label and human-readable destination host and is not replaced
    by a PROST-controlled shortened URL.
12. Each QR code, including its quiet zone, occupies at least 35 mm by 35 mm in a dedicated
    first-page informational area outside the Tally grid.
13. QR-code placement may increase pagination but does not reduce the 8.5 mm minimum row height, the
    51 mm Tally Name column, or any Product marking column.
14. Blank rows use the same Tally Name and Product grid as Consumer rows and provide no field for an
    email address or other direct profile identifier.
15. The printed `Generated at` value is identical in the confirmed preview and final PDF. The
    internal
    `Issued at` value may be later and does not change printable content or layout.
16. A layout profile is qualified before it may be used for issuance and is requalified after any
    change to QR encoding, QR dimensions, QR rendering, or the first-page informational area. The
    qualification uses both QR positions with valid HTTPS payloads whose exact decoded value is 200
    bytes and requires QR byte-mode encoding throughout. It prints the result at actual A3 size in
    monochrome on plain paper at 300 dpi or better.
17. Under 300-500 lux illumination and at a distance of 30-50 cm, each qualification QR code decodes
    within three seconds in three consecutive attempts on each of one Android device and one iOS
    device that receives vendor security updates on the qualification date. Timing begins when the
    complete QR code is visible to the default camera application; each attempt is reset by removing
    the QR code from view. A failed qualification prevents use of that layout profile.
18. Qualification evidence identifies the layout-profile version, tested PDF and payloads, print
    settings, device models and software versions, illumination and distance, tester and date, and
    the result of every attempt. Release verification demonstrates that no layout profile is made
    available for issuance without passing evidence for that version.

## Open Questions

- See [OQ-033](../open-questions/OQ-033-printed-tally-identifier.md) for a human-readable Tally
  identifier on every page.
- See [OQ-034](../open-questions/OQ-034-final-pdf-retention.md) for PDF artifact retention or
  reproducible generation.
- See [OQ-003](../open-questions/OQ-003-pseudonymized-tally-names.md).
- See the resolved [OQ-008](../open-questions/OQ-008-printable-product-columns.md) for printable
  Product-column traceability.
