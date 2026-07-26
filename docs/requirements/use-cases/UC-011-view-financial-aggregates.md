---
id: UC-011
title: View Financial Aggregates
status: draft
source: Product-owner interview on 2026-07-26
---

# UC-011: View Financial Aggregates

## Goal

A Treasurer reviews Organization-level financial and consumption totals without access to
identifiable Consumer records.

## Primary Actor

Treasurer

## Preconditions

- The Treasurer is authenticated with MFA.

## Main Flow

1. The Treasurer opens the aggregate overview.
2. PROST evaluates the requested aggregate against the accepted cohort and differencing policy.
3. PROST displays total Consumer credit and total Consumer debt separately only where the policy
   permits.
4. PROST displays permitted aggregate settled consumption, Unallocated Consumption, Deposits,
   Refunds, and Adjustments.
5. PROST suppresses Tally Names, email addresses, individual balances, individual transactions, and
   row-level audit identities.

## Business Rules

- [BR-004](../business-rules/BR-004-settlement-and-corrections.md)
- [BR-005](../business-rules/BR-005-balance-and-suspension.md)
- [BR-007](../business-rules/BR-007-privacy-and-pseudonymization.md)

## Quality Scenarios

- `QS-SEC-002`
- `QS-SEC-005`

## Acceptance Criteria

1. Treasurer-only access suppresses an aggregate unless the accepted cohort and differencing policy
   considers it sufficiently anonymous.
2. Aggregates reconcile mathematically with the underlying effective entries.
3. Credit and debt are shown separately rather than only as a net balance.
4. No CSV or bookkeeping export is available in the MVP.
5. If a person also has Organization Manager privileges, additional data is available only under
   those effective permissions and remains audited.

## Open Questions

- At what group size could aggregate combinations indirectly identify a Consumer?
- Are date-range filters required for the MVP?
- Is Product-level aggregate information required, and should it be suppressed below a privacy
  threshold?
- These questions are acceptance blockers under `OQ-002` in
  the [Open Question Register](../open-questions.md).
