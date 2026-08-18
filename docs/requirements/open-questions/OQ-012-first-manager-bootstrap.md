---
id: OQ-012
revision: 1
title: First Manager Bootstrap
question_status: resolved
priority: high
owner: product-owner
blocks: []
affected_artifacts:
  - BR-001@1
  - UC-010@1
  - UC-013@1
source: Open Question Register revision 1
---

# First Manager Bootstrap

## Question

How is the first Organization Manager established securely without allowing an untrusted registrant to claim the Organization?

## Product Owner Answer

A trusted Deployment Operator confirms one eligible opaque request through the one-time host command.

## Incorporation

The resolution is bound to `BR-001@1`, `UC-010@1`, and `UC-013@1`.

## Resolution Evidence

- [Pull request 192](https://github.com/s-kuhn/PROST/pull/192), which accepted the legacy resolution
  under Specification Governance revision 1.
- Historical commit `8fe8538`.
- One-time legacy-resolution migration exception in Specification Governance revision 2; ratification
  by the Open Question migration acceptance pull request is pending.
