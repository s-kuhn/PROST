---
title: Specification Governance
revision: 1
spec_maturity: accepted
lifecycle_status: active
delivery_status: not-applicable
source: Product-owner decisions on 2026-08-17
---

# Specification Governance

This policy defines how PROST specifications become authoritative and when they may authorize
architecture or implementation work.

## Authoritative Branch And Human Acceptance

`main` is the authoritative specification branch. Content and status changes on every other branch
are proposals only.

Only the human Product Owner may accept a specification revision. In the initial process, the
recorded acceptance action is the Product Owner personally merging the acceptance pull request into
`main`. The pull request must identify every artifact and revision being accepted. Agents may
prepare and update an acceptance pull request, but may not perform the Product Owner acceptance
action or merge it.

Repository controls should restrict acceptance and merge actions to the Product Owner. Until those
controls are automated, this policy remains binding and the pull-request history is the acceptance
record.

## Controlled Artifacts

The lifecycle in this policy applies to:

- use cases (`UC-*`);
- business rules (`BR-*`);
- quality scenarios (`QS-*`);
- Architecture Decision Records (`ADR-*`);
- normative product-scope, constraint, terminology, and governance documents.

Research references, the current-state inventory, and Arc42 summaries do not become normative by
carrying a documentation status.

## Independent Status Dimensions

Controlled artifacts use independent metadata fields:

```yaml
revision: 1
spec_maturity: draft
lifecycle_status: active
delivery_status: not-started
```

Artifact front matter is canonical. Indexes and derived views must match it and should be generated
or validated automatically; an index entry cannot change an artifact's status.

### Specification Maturity

- `draft`: incomplete, internally inconsistent, or blocked from Product Owner acceptance.
- `in-review`: complete, independently reviewed, and free of known acceptance blockers; the Product
  Owner can accept or reject the exact revision.
- `accepted`: the exact revision was accepted by the Product Owner through the pull-request process.

Allowed transitions are `draft -> in-review`, `in-review -> draft`, and `in-review -> accepted`.
Only the Product Owner acceptance action makes the last transition authoritative on `main`.

Changing normative content of an accepted artifact creates a new revision on a proposal branch. The
accepted revision on `main` remains authoritative until the Product Owner accepts and merges its
successor. There is no direct edit of accepted normative content on `main`.

### Lifecycle Status

- `active`: the artifact is currently applicable.
- `superseded`: an accepted successor replaces the artifact.
- `withdrawn`: the Product Owner removed the artifact without a successor.

Only the Product Owner may make `superseded` or `withdrawn` authoritative. Historical artifacts and
their acceptance evidence remain available.

### Delivery Status

- `not-started`: no delivery work is authorized or claimed for the current artifact revision.
- `in-progress`: implementation against the accepted revision is underway.
- `implemented`: implementation evidence claims that the accepted revision is satisfied.
- `verified`: current evidence demonstrates every linked acceptance criterion and quality measure at
  an appropriate observable seam.
- `not-applicable`: the artifact has no implementation lifecycle, for example a governance policy.

Delivery progress never replaces specification acceptance. A new accepted revision begins at
`not-started`. Stale evidence or a regression moves `verified` back to `implemented`; corrective work
moves `implemented` back to `in-progress`. Evidence remains associated with the revision it tested.

## Open Questions And Blockers

Every unresolved normative uncertainty has a stable `OQ-*` identifier. Open questions declare the
artifacts they affect and whether they block acceptance, architecture, implementation, or release.
Questions remain in the register after resolution with their outcome and evidence; IDs are never
deleted or reused.

An artifact with an acceptance blocker remains `draft`. Architecture and implementation must not
silently resolve a linked open question.

Only the Product Owner may make an open question's resolution or a reduction of its blocking scope
authoritative through the pull-request process. Resolution requires the explicit outcome, rationale
or source, affected artifact revisions, and acceptance evidence. Incorporating an answer into draft
requirements does not resolve the question by itself.

## Architecture Documentation

Accepted requirements, quality scenarios, ADRs, and governance policies are normative. Arc42 is a
derived view that summarizes and links those sources. Arc42 chapters use documentation coverage
(`placeholder`, `partial`, or `current`), not specification maturity, and cannot satisfy an
acceptance or implementation gate.

An accepted ADR establishes an architecture decision. Arc42 prose does not establish one by itself.

## Work-Item Gate Declaration

Every application-behavior work item must contain a complete declaration:

```yaml
gate_evidence:
  use_cases:
    - id: UC-###
      revision: 1
  business_rules:
    - id: BR-###
      revision: 1
  quality_scenarios:
    - id: QS-CATEGORY-###
      revision: 1
  architecture_decisions: []
  open_questions: []
  acceptance_criteria:
    - id: UC-###-AC-001
      verification_seam: observable interface or test level
  quality_measures:
    - id: QS-CATEGORY-###-MEASURE
      verification_seam: observable interface or test level
```

Every list is required, including an explicitly empty list. The Product Owner declares the lists
complete. An agent may propose the declaration but may not infer that an omitted category is empty
or that no architecture decision is required.

Acceptance criteria use stable `<requirement-id>-AC-###` identifiers. Each quality scenario has one
stable `<quality-scenario-id>-MEASURE` identifier unless multiple independently verifiable measures
require numbered suffixes. Draft artifacts that have not yet adopted these identifiers cannot pass
the implementation-readiness gate.

## Implementation Readiness

An application-behavior work item is ready only when all of these conditions hold:

1. Its gate declaration identifies exact artifact revisions and is complete.
2. Every listed use case, business rule, quality scenario, and ADR is `accepted` and `active` on
   `main`.
3. No listed or transitively linked open question blocks acceptance, architecture, or
   implementation.
4. Every acceptance criterion and quality measure has a stable identifier and a planned observable
   verification seam.
5. Architecture impact has been assessed. Every required decision has an accepted ADR; an empty ADR
   list is an explicit Product Owner decision, not an agent inference.
6. Contract compatibility, data migration, security, privacy, financial, audit, and operational
   impacts have been considered where applicable.
7. No unresolved conflict exists between authoritative sources.

Requirement acceptance alone is therefore not approval to implement. Documentation, research,
requirements refinement, and non-normative architecture option analysis may proceed while this gate
is closed.

## Initial Governance Migration

The first pull request governed by this policy also migrates historical status data. The Product
Owner has decided to preserve these exact revision-1 artifacts as accepted:

- Specification Governance;
- Licensing And Copyright;
- Release Governance;
- Open Question Register;
- `BR-005`;
- `BR-006`.

The acceptance pull request must list all six revisions explicitly. The Product Owner acceptance
action and merge into `main` ratify their migrated metadata. Until that merge, every status in the
migration branch remains a proposal and grants no architecture or implementation authority.
