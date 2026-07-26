---
id: UC-010
title: Manage Organization
status: draft
source: Product-owner interview on 2026-07-26
---

# UC-010: Manage Organization

## Goal

Organization Managers configure the single MVP Organization and maintain privileged application
roles.

## Primary Actor

Organization Manager

## Configuration

- Organization display title.
- Printed Tally instruction and contact text.
- Automatic debt-suspension enabled state and, when enabled, a maximum-debt amount in EUR.
- Optional payment-link label and HTTPS URL.
- Organization Manager and Treasurer role assignments.

## Main Flow

1. The manager opens Organization settings.
2. The manager changes one or more values.
3. When automatic debt suspension is enabled without a retained amount, PROST requires a nonnegative
   maximum-debt amount with cent precision.
4. PROST previews consequential changes, including Consumer state changes caused by enabling,
   disabling, or changing automatic debt suspension.
5. The manager confirms.
6. If the suspension configuration or an affected Consumer balance or state changed after preview,
   PROST rejects confirmation without applying any change and requires a new preview.
7. Otherwise, PROST atomically persists the suspension configuration, all resulting Consumer state
   transitions, and the audit record.

## Role Management

1. An existing Organization Manager may grant or revoke Organization Manager and Treasurer roles.
2. Organization-wide roles require MFA before privileged access.
3. The last Organization Manager cannot remove their own Organization Manager role.
4. Consumer, Organization Manager, and Treasurer roles may be combined.

## Business Rules

- [BR-001](../business-rules/BR-001-consumer-lifecycle.md)
- [BR-005](../business-rules/BR-005-balance-and-suspension.md)
- [BR-007](../business-rules/BR-007-privacy-and-pseudonymization.md)

## Quality Scenarios

- `QS-SEC-002`
- `QS-OPS-002`

## Acceptance Criteria

1. Only Organization Managers may change Organization configuration or application roles.
2. The payment link accepts HTTPS URLs only and has no automatic payment effect.
3. Enabling, disabling, or changing automatic debt suspension persists the setting, all resulting
   Consumer state transitions, and the audit record atomically.
4. Role and consequential setting changes are auditable.
5. An Organization cannot be left without an Organization Manager.
6. Initial Organization setup defaults automatic debt suspension to disabled and leaves the
   maximum-debt amount empty.
7. Enabling automatic debt suspension is rejected until a maximum-debt amount is provided or
   retained from earlier configuration.
8. Disabling automatic debt suspension changes Suspended Consumers to Active without changing
   Inactive Consumers.
9. Disabling automatic debt suspension retains its maximum-debt amount without applying it;
   re-enabling prepopulates that retained amount.
10. Confirmation based on a stale preview has no effect and requires a new preview.

## Open Questions

- `OQ-012`: How is the first Organization Manager established securely?
- `OQ-013`: Which settings, if any, may change while a Tally is Issued or in Settlement Draft?
