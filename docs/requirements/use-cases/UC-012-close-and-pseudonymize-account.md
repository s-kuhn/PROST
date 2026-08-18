---
id: UC-012
title: Close And Pseudonymize Account
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
source: Product-owner interview on 2026-07-26
---

# UC-012: Close And Pseudonymize Account

## Goal

A Consumer ends active participation and, after resolving their balance, requests removal of direct
identity data without corrupting financial history.

## Primary Actor

Consumer

## Close Participation Flow

1. The Consumer requests closure of active participation.
2. PROST explains that the Consumer will be excluded from future Tallies but remains responsible for
   debt and entitled to credit.
3. The Consumer confirms.
4. PROST changes the Consumer to Inactive without changing the balance or historical records.
5. The Consumer retains authenticated access to account history and payment information.

## Pseudonymization Flow

1. An Inactive Consumer with zero balance requests pseudonymization.
2. PROST verifies that the Consumer holds no Organization Manager or Treasurer role. If they do, the
   request is blocked until an existing Organization Manager revokes those roles safely.
3. PROST explains the irreversible effect and documented limits involving audit history, already
   printed sheets, and backup rotation.
4. The Consumer confirms through a sufficiently recent authenticated session.
5. PROST removes or unlinks login and direct profile identifiers according to the accepted
   pseudonymization policy and changes the Consumer state to Pseudonymized.
6. The former identity can no longer authenticate to the pseudonymized Consumer record.

## Business Rules

- [BR-001](../business-rules/BR-001-consumer-lifecycle.md)
- [BR-007](../business-rules/BR-007-privacy-and-pseudonymization.md)

## Quality Scenarios

- [QS-SEC-004](../quality-scenarios/QS-SEC-004-pseudonymization.md)

## Acceptance Criteria

1. A Consumer can make their own participation Inactive without manager action.
2. Closure does not alter a nonzero balance or revoke account access.
3. Pseudonymization is unavailable until the Consumer is Inactive with zero balance.
4. Pseudonymization cannot proceed while any privileged application role remains assigned to the
   Consumer.
5. Re-registration after pseudonymization creates a new Consumer profile rather than reconnecting
   ordinary application history.
6. Historical Tally-name handling is not acceptance-ready until
   [OQ-003](../open-questions/OQ-003-pseudonymized-tally-names.md) is resolved.

## Open Questions

- See [OQ-003](../open-questions/OQ-003-pseudonymized-tally-names.md),
  [OQ-006](../open-questions/OQ-006-retention-rules.md), and
  [OQ-007](../open-questions/OQ-007-restore-after-privacy-actions.md).
