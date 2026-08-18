---
id: QS-USA-004
title: Printable Tally Legibility
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
blocked_by:
  - OQ-033
source: Existing Arc42 quality scenario migrated on 2026-08-17
---

# QS-USA-004: Printable Tally Legibility

- Source: Organization Manager.
- Stimulus: Previews a Tally containing up to 50 Consumers and 5 active Products with relative width
  weights.
- Environment: A3 landscape output.
- Response: PROST applies the physical layout baseline in
  [BR-006](../business-rules/BR-006-product-lifecycle.md), wraps complete Product names, shrinks
  Product headings from 12 pt to no less than 10 pt, keeps the complete repeated grid-heading row
  between 8.5 mm and 25.5 mm, repeats headings on vertical pages, preserves the 6 mm page margins,
  8.5 mm minimum row height, 51 mm Tally Name column, and 17 mm minimum Product-column width, keeps
  all Product columns together, and places labeled registration and optional payment QR codes in a
  dedicated first-page area outside the Tally grid.
- Measure: Except for a non-layout preview indicator, preview and final A3 landscape PDF have
  identical printable content and layout. Issuance is blocked outside the one-to-five active Product
  range, when a Product column would be narrower than 17 mm, or when complete headers cannot fit at
  10 pt within 25.5 mm without clipping or overlap. The Organization Manager confirms practical
  marking space. Each QR code, including its quiet zone, is at least 35 mm square, and its decoded
  payload is no more than 200 bytes. Before a layout profile is used, and after a relevant QR or
  informational-area change, both QR positions are qualified with valid 200-byte HTTPS payloads that
  require QR byte-mode encoding throughout. When printed at actual A3 size in monochrome on plain
  paper at 300 dpi or better, under 300-500 lux illumination and at a distance of 30-50 cm, each
  qualification QR decodes within three seconds in three consecutive attempts on each of one Android
  and one iOS device receiving vendor security updates. A failed qualification prevents use of the
  layout profile. Version-linked evidence records the fixture, environment, devices, attempts, and
  results and demonstrates that only a passing profile is available for issuance.
- Decision traceability: The resolved
  [OQ-008](../open-questions/OQ-008-printable-product-columns.md) records the printable
  Product-column decision.
