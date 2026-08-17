---
id: QS-USA-001
title: Consumer Device And Language
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
blocked_by:
  - OQ-009
source: Existing Arc42 quality scenario migrated on 2026-08-17
---

# QS-USA-001: Consumer Device And Language

- Source: Consumer.
- Stimulus: Registers or views account information on a supported mobile or desktop browser.
- Environment: German or English preference.
- Response: The interface uses the saved preference, otherwise a supported browser locale, otherwise
  German.
- Measure: All Consumer MVP flows work at supported mobile and desktop viewport sizes in both
  languages. Supported environments remain open through `OQ-009`.
