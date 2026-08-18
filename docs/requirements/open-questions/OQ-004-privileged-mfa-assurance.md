---
id: OQ-004
revision: 1
title: Privileged MFA Assurance
question_status: open
priority: high
owner: product-owner
blocks:
  - acceptance
  - architecture
affected_artifacts:
  - UC-010@1
  - UC-013@1
  - QS-SEC-002@1
  - QS-OPS-001@1
source: Open Question Register revision 1
---

# Privileged MFA Assurance

## Question

Which MFA factors, enrollment, recovery, replacement, authentication age, and OIDC assurance
evidence are acceptable for privileged roles?

## Context

This question affects `UC-010@1`, `UC-013@1`, `QS-SEC-002@1`, and `QS-OPS-001@1` and blocks
acceptance and architecture.

These controls form one privileged-authentication policy: factor acceptance is unsafe without its
lifecycle, recovery, recency, and federated-assurance rules. The Product Owner must answer the policy
as a whole; a partial answer leaves this record open.

## Decision Preparation

Options, consequences, and a recommendation are not yet complete. This question remains open.
