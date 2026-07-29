---
id: UC-001
title: Register Consumer
status: draft
source: Product-owner interview on 2026-07-26
---

# UC-001: Register Consumer

## Goal

A person establishes an authenticated PROST Consumer profile and requests participation in the
Organization's Tally workflow.

## Primary Actor

Consumer

## Preconditions

- Registration is enabled.
- A local identity option or configured OIDC provider is available.
- Email verification and recovery delivery are operational for local identities.

## Main Flow

1. The person creates a local identity or authenticates through an allowed OIDC provider.
2. The identity provider verifies the email address.
3. PROST requests any missing domain-profile information.
4. PROST suggests a Tally Name from available profile attributes.
5. The Consumer chooses an Organization-unique Tally Name and a UI language.
6. PROST explains that the Tally Name will be printed in a physically public location.
7. The Consumer confirms the profile.
8. PROST creates the Consumer in `Pending Approval` and displays that status.

## Alternatives

- If the Tally Name is already used, PROST requires another value.
- If the external identity matches an existing Consumer, PROST must not create a duplicate without
  secure account-linking proof.
- If email verification is incomplete, PROST does not create an approvable Consumer profile.

## Business Rules

- [BR-001](../business-rules/BR-001-consumer-lifecycle.md)
- [BR-007](../business-rules/BR-007-privacy-and-pseudonymization.md)

## Quality Scenarios

- `QS-OPS-002`
- `QS-USA-001`

## Acceptance Criteria

1. A person who has authenticated through an allowed authentication source and whose email address
   is verified can complete the PROST profile without an Organization Manager creating the identity.
2. Duplicate Tally Names are rejected within the Organization.
3. A new Consumer is Pending Approval and absent from regular rows of the current and future Tally
   until approved.
4. The Consumer can sign in and inspect approval status while pending.
5. Registration records the privacy notice version or equivalent evidence shown to the Consumer.

## Open Questions

- See `OQ-005` in the [Open Question Register](../open-questions.md).
- Which profile attributes are mandatory besides Tally Name and verified email?
