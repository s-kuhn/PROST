---
id: OQ-013
revision: 1
title: Settings Effective Time
question_status: resolved
priority: medium
owner: product-owner
blocks: []
affected_artifacts:
  - UC-010@1
  - BR-002@1
  - BR-003@1
  - BR-004@1
source: Open Question Register revision 1
---

# Settings Effective Time

## Question

Which Organization settings may change while a Tally is Issued or in Settlement Draft, and when do those changes take effect?

## Product Owner Answer

Catalog/layout changes affect the next Tally; role and suspension changes apply on confirmation;
lock-duration changes affect the next lock.

## Incorporation

The resolution is bound to `UC-010@1`, `BR-002@1`, `BR-003@1`, and `BR-004@1`.

## Resolution Evidence

- [Pull request 192](https://github.com/s-kuhn/PROST/pull/192), which accepted the legacy resolution
  under Specification Governance revision 1.
- Historical commit `433b525`.
- One-time legacy-resolution migration exception in Specification Governance revision 2; ratification
  by the Open Question migration acceptance pull request is pending.
