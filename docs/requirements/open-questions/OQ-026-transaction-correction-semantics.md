---
id: OQ-026
revision: 1
title: Account Transaction Correction Semantics
question_status: open
priority: high
owner: product-owner
blocks:
  - acceptance
  - architecture
affected_artifacts:
  - BR-004@1
  - UC-007@1
  - UC-008@1
source: Open Question Register revision 1
---

# Account Transaction Correction Semantics

## Question

Which Account Transaction fields may be corrected, and which user-visible audited revision semantics
are required?

## Context

This question affects `BR-004@1`, `UC-007@1`, and `UC-008@1` and blocks acceptance and
architecture.

Correctable fields and user-visible history form one correction contract: a field cannot be made
correctable without defining how its original and revised values remain auditable. A partial answer
leaves this record open.

## Decision Preparation

Options, consequences, and a recommendation are not yet complete. This question remains open.
