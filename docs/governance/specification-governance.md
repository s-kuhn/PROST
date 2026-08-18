---
title: Specification Governance
revision: 2
spec_maturity: accepted
lifecycle_status: active
delivery_status: not-applicable
source: Product-owner decisions on 2026-08-17 and 2026-08-18
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

Open-question records use the specialized question lifecycle defined below rather than requirement
maturity or delivery status.

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
`not-started`. Stale evidence or a regression moves `verified` back to `implemented`; corrective
work moves `implemented` back to `in-progress`. Evidence remains associated with the revision it
tested.

## Open Questions And Blockers

Every unresolved normative uncertainty has an individual record under
[`docs/requirements/open-questions/`](../requirements/open-questions/), a stable `OQ-*` identifier,
and a revision. Its front matter is canonical and declares the owner, priority, affected artifact
revisions, blocking stages, and question status. The derived
[Open Question Index](../requirements/open-questions.md) cannot change a record. New records use the
versioned [Open Question template](templates/open-question.md).

Question status follows this lifecycle:

- `open`: context, options, consequences, or a recommendation are not yet decision-ready.
- `ready-for-decision`: the decision preparation is complete and independently reviewed.
- `answered`: the Product Owner selected an outcome, but it is not yet incorporated and reviewed in
  every affected artifact.
- `resolved`: the answer is incorporated in every affected artifact and the resulting revisions were
  independently reviewed for consistency.
- `deferred`: the Product Owner explicitly moved the question outside current scope and recorded a
  reactivation trigger.
- `superseded`: another identified open-question record replaces this question.

The normal sequence is `open -> ready-for-decision -> answered -> resolved`. Review findings may
return `ready-for-decision` to `open`. The Product Owner may move `open` or `ready-for-decision` to
`deferred` or `superseded`, and may return `answered` to `open` when an answer is withdrawn before
resolution. A deferred record's reactivation trigger makes it eligible for reopening but does not
change its status automatically. Every `deferred -> open` transition requires a Product Owner
decision and a new revision. Reopening a resolved record or reactivating a superseded record also
requires a Product Owner decision and a new revision; a superseded record may reactivate only when
its replacement is withdrawn without another active successor.

Open, `ready-for-decision`, and answered records continue to block every stage in their `blocks`
list. Deferred and resolved records have an empty `blocks` list. A superseded record has an empty
`blocks` list and identifies its active replacement.

Question records remain after resolution, deferral, or supersession; IDs are never deleted or
reused. An agent may create an open record and prepare it for decision, but must not invent options,
recommendations, answers, or outcomes that require Product Owner input.

The affected revision records where the uncertainty was identified. Unless the Product Owner
explicitly narrows or removes the binding, every unresolved block also applies to all successor
revisions of the same artifact ID. A successor revision cannot bypass an open question by omitting
its backlink.

An artifact with an acceptance blocker remains `draft`. Architecture and implementation must not
silently resolve a linked open question.

Only the Product Owner may make an answer, deferral, supersession, reopening, resolution, or
reduction of blocking scope authoritative through the pull-request process. An answer records the
selected option and conditions. Resolution additionally requires the explicit outcome, rationale or
source, affected artifact revisions, independent consistency review, and acceptance evidence.
Incorporating an answer into draft requirements does not resolve the question by itself.

A change to the question, status, blocking stages, affected artifacts, decision options,
recommendation, Product Owner answer, incorporation references, replacement, reactivation trigger,
or resolution evidence increments the question revision. Editorial corrections that do not change
meaning may retain the revision and must be identified as non-normative in the pull request.

Each question record contains the question, context, decision preparation, Product Owner answer,
incorporation references, and resolution evidence appropriate to its status. Decision options and a
recommendation belong in the question record rather than a separate decision-packet artifact.

## Specification Review Packets

Every specification review presented for Product Owner action uses the versioned
[Specification Review Packet template](templates/specification-review-packet.md). The pull-request
description is the durable review packet and acceptance record; a second repository file is not
created for each review.

A review packet contains:

- the review goal and exact artifact revisions in scope;
- the non-normative inputs and proposed normative delta;
- decision-ready open questions requiring Product Owner answers;
- independent findings with stable packet-local IDs, severity, disposition, rationale, and
  resolution references;
- explicit identity, authorization, financial, audit, privacy, operational, migration, and future
  change review outcomes;
- a readiness verdict, acceptance manifest where applicable, and verification evidence.

Requirements, domain, security, and architecture findings use the prefixes `REQ-F-###`,
`DOM-F-###`, `SEC-F-###`, and `ARCH-F-###`. Finding disposition is `open`, `resolved`, `deferred`,
or
`rejected`. The packet owner proposes disposition, but the originating reviewer records concurrence
or continued objection after re-review. Any finding that the originating reviewer still considers
blocking keeps the packet blocked. Deferred and rejected findings require explicit rationale,
Product Owner agreement when they affect the requested decision, and reviewer concurrence that they
do not block that action. A resolved finding links the changed artifact revision and independent
re-review evidence.

The readiness verdict distinguishes `Ready for Product Owner answers`, `Ready for specification
acceptance`, and `Blocked`. A packet requesting answers has no acceptance manifest. A packet
requesting specification acceptance has no unanswered decision request: every acceptance blocker is
resolved, every relevant question is resolved or explicitly deferred without an acceptance block,
and the independent reviewers report no unresolved blocking finding. The acceptance manifest remains
explicit and lists only exact revisions actually presented for acceptance. One packet cannot request
answers and specification acceptance simultaneously.

Until automated validation exists, every pull request that changes an open-question record includes
an explicit check that the derived index matches all canonical records and every affected artifact
contains a backlink.

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
  architecture_decisions: [ ]
  open_questions: [ ]
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

The initial governance migration was accepted through
[pull request 192](https://github.com/s-kuhn/PROST/pull/192). It preserved these exact revision-1
artifacts as accepted:

- Specification Governance;
- Licensing And Copyright;
- Release Governance;
- Open Question Register;
- `BR-005`;
- `BR-006`.

The pull request listed all six revisions explicitly. The Product Owner merge into `main` ratified
their migrated metadata. Later revisions continue to follow the normal acceptance process.

## Open Question Record Migration

Specification Governance revision 2 replaces the accepted Open Question Register revision 1 with
individual revision-1 records for `OQ-002` through `OQ-017` and `OQ-019` through `OQ-039`. The exact
record set is enumerated by the migration pull request and the derived
[Open Question Index](../requirements/open-questions.md). The historical register remains available
through [pull request 192](https://github.com/s-kuhn/PROST/pull/192) and Git history.

The migration preserves every recorded question, priority, blocking stage, affected artifact,
answer, and resolution. It proposes the specialized `deferred` status for `OQ-024` and `OQ-037`
because the accepted register already recorded both as deferred beyond MVP with no blocking stage.
The Product Owner merge of the migration acceptance pull request makes the individual records the
authoritative successors, accepts the two explicit deferrals, and retires the register as a
normative artifact. Until that merge, Open Question Register revision 1 on `main` remains
authoritative.

The accepted register already marked `OQ-008`, `OQ-011`, `OQ-012`, and `OQ-013` resolved before the
durable review-packet format existed. Their individual records preserve the Product Owner-accepted
outcomes and historical commits as a one-time migration exception. The migration acceptance pull
request ratifies those four legacy statuses without claiming review evidence that was not recorded
at the time. The revision-2 independent-review evidence requirements apply prospectively to every
new, reopened, or changed resolution and cannot use this exception.
