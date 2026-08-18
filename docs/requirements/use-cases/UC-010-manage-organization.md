---
id: UC-010
title: Manage Organization
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
source: Product-owner interviews on 2026-07-26, 2026-07-29, and 2026-08-03
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
- Settlement Draft edit-lock inactivity duration in whole minutes.
- Organization Manager and Treasurer role assignments.

## Main Flow

1. The manager opens Organization settings.
2. The manager changes one or more values.
3. PROST rejects a Settlement Draft edit-lock inactivity duration outside the range defined by
   [BR-004](../business-rules/BR-004-settlement-and-corrections.md).
4. When automatic debt suspension is enabled without a retained amount, PROST requires a nonnegative
   maximum-debt amount with cent precision.
5. PROST previews consequential changes, including Consumer state changes caused by enabling,
   disabling, or changing automatic debt suspension.
6. The manager confirms.
7. If the suspension configuration or an affected Consumer balance or state changed after preview,
   PROST rejects confirmation without applying any change and requires a new preview.
8. Otherwise, PROST persists the confirmed Organization configuration changes. For a suspension
   configuration change, PROST atomically persists the setting, all resulting Consumer state
   transitions, and the audit record.

## Role Management

The first Organization Manager is established through
[UC-013](UC-013-bootstrap-first-organization-manager.md). After that bootstrap:

1. An existing Organization Manager may grant or revoke Organization Manager and Treasurer roles.
2. Organization-wide roles require MFA before privileged access.
3. The last Organization Manager cannot remove their own Organization Manager role.
4. A Consumer may hold the Organization Manager role, the Treasurer role, or both.

## Business Rules

- [BR-001](../business-rules/BR-001-consumer-lifecycle.md)
- [BR-004](../business-rules/BR-004-settlement-and-corrections.md)
- [BR-005](../business-rules/BR-005-balance-and-suspension.md)
- [BR-007](../business-rules/BR-007-privacy-and-pseudonymization.md)

## Quality Scenarios

- [QS-SEC-002](../quality-scenarios/QS-SEC-002-privileged-mfa.md)
- [QS-OPS-002](../quality-scenarios/QS-OPS-002-provider-neutral-integration.md)

## Acceptance Criteria

1. Except for initial Organization Manager bootstrap through
   [UC-013](UC-013-bootstrap-first-organization-manager.md), only Organization Managers may change
   Organization configuration or application roles.
2. The payment link accepts HTTPS URLs only and has no automatic payment effect.
3. Enabling, disabling, or changing automatic debt suspension persists the setting, all resulting
   Consumer state transitions, and the audit record atomically.
4. Role and consequential setting changes are auditable.
5. After successful initial bootstrap in the current application state, an Organization cannot be
   left without an Organization Manager.
6. Initial Organization setup defaults automatic debt suspension to disabled and leaves the
   maximum-debt amount empty.
7. Enabling automatic debt suspension is rejected until a maximum-debt amount is provided or
   retained from earlier configuration.
8. Disabling automatic debt suspension changes Suspended Consumers to Active without changing
   Inactive Consumers.
9. Disabling automatic debt suspension retains its maximum-debt amount without applying it;
   re-enabling prepopulates that retained amount.
10. Confirmation based on a stale preview has no effect and requires a new preview.
11. While a Tally is Issued or in Settlement Draft, the Organization Manager may change the
    Organization display title, printed Tally instruction and contact text, and Payment Link label
    or destination. A confirmed change becomes the current Organization configuration immediately
    but does not alter the open Tally Snapshot or its final PDF; it is first reflected in the next
    Tally preview.
12. Confirmed automatic debt-suspension changes and their resulting Consumer state transitions take
    effect upon confirmation. They affect Consumer inclusion only in the next Tally preview; they do
    not alter the open Tally Snapshot or final PDF, and marks for Consumers in that Snapshot remain
    eligible for Settlement.
13. Confirmed Organization Manager and Treasurer role changes take effect without waiting for the
    open Tally to be Settled or Canceled.
14. A new Organization has the default Settlement Draft edit-lock inactivity duration defined by
    [BR-004](../business-rules/BR-004-settlement-and-corrections.md). An Organization Manager can
    configure either inclusive boundary value, while a value outside the range or a
    fractional-minute value is rejected without changing the current setting.
15. Changing the inactivity duration does not alter an edit lock that is already held. A lock
    acquired after the configuration change uses the changed duration.

## Open Questions

- See [OQ-004](../open-questions/OQ-004-privileged-mfa-assurance.md) for privileged MFA assurance.
- See the resolved [OQ-012](../open-questions/OQ-012-first-manager-bootstrap.md) for first-manager
  bootstrap traceability.
- See the resolved [OQ-013](../open-questions/OQ-013-settings-effective-time.md) for settings
  effective-time traceability.
