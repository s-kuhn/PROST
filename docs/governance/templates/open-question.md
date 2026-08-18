---
title: Open Question Template
revision: 1
spec_maturity: accepted
lifecycle_status: active
delivery_status: not-applicable
source: Product-owner workflow decision on 2026-08-18
---

# Open Question Template

Copy this structure into `docs/requirements/open-questions/OQ-###-short-title.md`. Replace every
placeholder. Remove status-specific sections only when Specification Governance does not require
them for the selected status.

```yaml
---
id: OQ-###
revision: 1
title: Concise Decision Title
question_status: open
priority: high
owner: product-owner
blocks:
  - acceptance
affected_artifacts:
  - UC-###@1
superseded_by: null
source: Product Owner input or requirement review reference
---
```

# OQ-###: Concise Decision Title

## Question

Ask one focused normative question. Include coupled subquestions only when they form one atomic
policy decision and must share one status; otherwise create separate records.

## Context

Explain why the decision is needed, which invariant or outcome it affects, and why an agent cannot
decide it safely.

## Options

### Option A: Name

Describe the outcome, consequences, risks, and relevant examples.

### Option B: Name

Describe the materially different outcome, consequences, risks, and relevant examples.

## Recommendation

Recommend an option with rationale, or state why no recommendation can yet be made. A record cannot
be `ready-for-decision` while this section or credible options are incomplete.

## Product Owner Answer

Record the selected option, conditions, rationale supplied by the Product Owner, and acceptance
evidence. Also record a Product Owner deferral, supersession, reopening, resolution, or
blocker-scope change when that is the requested action. Agents must not invent this content.

## Incorporation

List every changed artifact and exact revision that incorporates the answer.

## Resolution Evidence

Link the independent consistency review and Product Owner acceptance action. A record cannot be
`resolved` until all affected artifacts are incorporated and reviewed.

## Reactivation Trigger

For `deferred` questions, state the observable scope or event that makes the question eligible for a
Product Owner reopening decision. The trigger does not change status automatically.

## Supersession

For `superseded` questions, identify the active replacement record and explain why it fully replaces
this question.
