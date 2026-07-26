---
id: UC-002
title: Manage Consumer Status
status: draft
source: Product-owner interview on 2026-07-26
---

# UC-002: Manage Consumer Status

## Goal

An Organization Manager reviews participation requests and manages Consumer eligibility without
changing historical Tallies.

## Primary Actor

Organization Manager

## Main Flows

### Approve Consumer

1. The manager views Pending Approval Consumers.
2. The manager verifies identity and Tally Name suitability.
3. The manager approves the Consumer.
4. PROST changes the state to Active for future Tally issuance.

Approval may also occur while mapping a handwritten row during [UC-006](UC-006-settle-tally.md).

### Make Consumer Inactive

1. The manager selects an Active or Suspended Consumer.
2. The manager records an optional reason and confirms.
3. PROST makes the Consumer Inactive for future Tallies while preserving access and balance history.

### Reactivate Consumer

1. The manager selects an Inactive Consumer.
2. PROST checks the debt threshold.
3. PROST changes the state to Active or Suspended as required by the current balance.

## Business Rules

- [BR-001](../business-rules/BR-001-consumer-lifecycle.md)
- [BR-005](../business-rules/BR-005-balance-and-suspension.md)

## Acceptance Criteria

1. Only an Organization Manager can approve a Consumer or change another Consumer's participation
   state; a Consumer may close their own participation
   through [UC-012](UC-012-close-and-pseudonymize-account.md).
2. State changes are attributed to an actor and timestamp.
3. Changes never add or remove rows from an already Issued Tally.
4. Inactive and Suspended Consumers can still inspect their accounts.
5. A manually Inactive Consumer does not reactivate solely because their balance changes.

## Open Questions

- Should rejection be a state or deletion of an unused pending profile?
- Must the Consumer receive an activation notification inside PROST?
