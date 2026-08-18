---
id: UC-013
title: Bootstrap First Organization Manager
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
source: Product-owner interview on 2026-07-29
---

# UC-013: Bootstrap First Organization Manager

## Goal

The Deployment Operator authorizes the intended first Organization Manager after that person has
created and secured their own identity, without allowing registration order to confer control of the
Organization.

## Primary Actor

Deployment Operator

## Supporting Actor

Prospective Organization Manager

## Preconditions

- The deployment has no Organization Manager.
- The prospective manager has registered through [UC-001](UC-001-register-consumer.md), verified
  their email, completed their Consumer profile, and remains Pending Approval.
- The prospective manager has completed MFA enrollment for the selected authentication source and
  can authenticate with evidence satisfying the accepted privileged MFA policy.
- Initial-manager bootstrap has never completed for the Organization and remains open.
- The Deployment Operator has authenticated administrative access to the deployment host.
- The intended manager has contacted the Deployment Operator to say that their registration and MFA
  enrollment are complete.

## Trigger

The prospective manager asks the Deployment Operator to authorize their completed registration as
the first Organization Manager.

## Main Flow

1. The prospective manager authenticates with evidence satisfying the accepted privileged MFA policy
   and requests initial Organization Manager bootstrap.
2. PROST creates a unique opaque bootstrap request that is immutably bound to the requesting
   Consumer and the authentication event, then presents its identifier. The identifier contains no
   email, Tally Name, role, or registration-order information and grants no role or permission by
   itself.
3. The prospective manager contacts the Deployment Operator and says that the bootstrap request is
   ready. This contact does not itself grant authority in PROST.
4. From an authenticated administrative session on the deployment host, the operator starts the
   documented interactive bootstrap command. No separate PROST operator authentication is required.
5. The command displays all eligible outstanding requests by request identifier, verified email,
   Tally Name, authentication source, request time, and a human-readable MFA-assurance result and
   authentication time.
6. Based on the expected manager's contact and the displayed information, the operator selects one
   request and explicitly confirms its target. PROST does not independently prove that the selected
   person is authorized to represent the Organization.
7. PROST verifies immediately before the change that initial-manager bootstrap remains open, no
   Organization Manager exists, the request is unused and remains bound to the displayed Consumer,
   the Consumer remains Pending Approval, and every identity and MFA-assurance detail displayed for
   confirmation is unchanged and still valid under the accepted privileged MFA policy.
8. PROST atomically changes the Consumer to Active, assigns the Organization Manager role, records
   the Audit Trail, consumes all outstanding initial-manager bootstrap requests, and closes
   initial-manager bootstrap in the current application state.
9. The command reports the completed assignment without displaying identity credentials, MFA
   secrets, or recovery information.

## Trust Boundary

The Deployment Operator is a trusted infrastructure administrator under
[BR-007](../business-rules/BR-007-privacy-and-pseudonymization.md). Authenticated access to the
deployment host is sufficient operator authority for initial bootstrap. The product accepts the
residual risk that the operator could select an impostor; the intended operational safeguard is that
the expected manager contacts the operator during initial setup before confirmation.

PROST does not separately identify the human using the authenticated host session. The Audit Trail
identifies the actor as the Deployment Operator bootstrap action invoked through authenticated host
administration.

## Bootstrap Request Eligibility

An outstanding bootstrap request is eligible for display and selection only while it is unused, its
bound Consumer remains Pending Approval with verified email, its bound identity and MFA-assurance
details remain unchanged and satisfy the accepted privileged MFA policy, and initial-manager
bootstrap remains open.

## Alternatives

- Any Consumer who satisfies the request prerequisites may create a bootstrap request, but neither
  being the first registrant nor being the first requester grants priority or authority.
- Multiple Pending Approval Consumers and bootstrap requests may exist. The command acts only on the
  request explicitly selected by the operator and displays its target details before confirmation.
- An outstanding request that is not currently eligible is not displayed for selection and cannot be
  confirmed.
- A bootstrap request does not expire solely because time passes. It becomes unusable when consumed,
  when its bound Consumer or authentication details no longer satisfy the confirmation checks, or
  when initial-manager bootstrap closes.
- Restoring a backup reproduces the bootstrap state contained in that backup. A backup created
  before successful initial bootstrap restores bootstrap as open and requires this use case to be
  completed again. A backup created after successful initial bootstrap restores bootstrap as closed.
- An unknown or consumed request, a target that no longer satisfies the prerequisites, or an
  Organization that already has a manager is rejected without changing Consumer state or roles.
- If any displayed target or assurance detail changes before confirmation, PROST rejects the
  confirmation without effect and requires the operator to inspect newly displayed details.
- A closed initial-manager bootstrap is rejected without effect even if no Organization Manager
  currently exists.
- The operator may stop when the displayed details do not identify the intended manager; stopping
  has no effect.
- If any state transition, role assignment, Audit Trail write, request consumption, or bootstrap
  closure fails, none of them takes effect.
- After initial bootstrap, Organization Managers assign further Organization Manager and Treasurer
  roles through [UC-010](UC-010-manage-organization.md).

## Business Rules

- [BR-001](../business-rules/BR-001-consumer-lifecycle.md)
- [BR-007](../business-rules/BR-007-privacy-and-pseudonymization.md)

## Quality Scenarios

- [QS-SEC-002](../quality-scenarios/QS-SEC-002-privileged-mfa.md)
- [QS-OPS-001](../quality-scenarios/QS-OPS-001-reproducible-installation.md)
- [QS-OPS-002](../quality-scenarios/QS-OPS-002-provider-neutral-integration.md)
- [QS-OPS-003](../quality-scenarios/QS-OPS-003-portable-recovery.md)

## Acceptance Criteria

1. Registration order and possession of a bootstrap request identifier do not grant application
   roles or change Consumer participation state.
2. Ordinary public application access cannot invoke the operator's interactive bootstrap command;
   authenticated administrative access to the deployment host requires no additional PROST operator
   credential.
3. The operator can inspect all eligible outstanding requests and select exactly one using the
   displayed request identifier, verified email, Tally Name, authentication source, request time,
   MFA-assurance result, and authentication time.
4. The command requires explicit confirmation of the displayed target and does not require direct
   data-store modification or application-source editing.
5. Successful confirmation changes exactly the selected Consumer from Pending Approval to Active,
   assigns that Consumer the Organization Manager role, records the Deployment Operator bootstrap
   action, target, time, original state, revised state, and bootstrap reason in the Audit Trail,
   consumes all outstanding bootstrap requests, and closes initial bootstrap as one logical
   operation.
6. A failure exposes no partial role, Consumer-state, Audit Trail, request-consumption, or
   bootstrap- closure result.
7. After the first successful bootstrap, every outstanding or new initial-manager bootstrap request
   and every repeated command invocation is rejected without effect unless a backup predating that
   successful bootstrap is later restored.
8. Other Pending Approval Consumers remain unchanged.
9. The new Organization Manager cannot use privileged application access unless the authentication
   context satisfies the accepted MFA policy.
10. The command output and Audit Trail contain no credentials, MFA-factor secrets, recovery
    information, or reusable authentication assertion.
11. Under concurrent confirmations, at most one initial-manager bootstrap succeeds; every other
    confirmation is rejected without changing Consumer state or roles.

## Open Questions

- [OQ-004](../open-questions/OQ-004-privileged-mfa-assurance.md) defines acceptable privileged MFA
  factors, enrollment, recovery, authentication age, and assurance evidence.
- [OQ-005](../open-questions/OQ-005-identity-linking.md) defines safe handling of duplicate local
  and OIDC identities.
- [OQ-006](../open-questions/OQ-006-retention-rules.md) defines retention for the bootstrap Audit
  Trail and related security records.
- The resolved [OQ-012](../open-questions/OQ-012-first-manager-bootstrap.md) records first-manager
  bootstrap traceability.
