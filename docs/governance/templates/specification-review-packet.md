---
title: Specification Review Packet Template
revision: 1
spec_maturity: accepted
lifecycle_status: active
delivery_status: not-applicable
source: Product-owner workflow decision on 2026-08-18
---

# Specification Review Packet

Use this template as the pull-request description for a specification review. Remove instructional
placeholders and this file's YAML front matter, but keep every section. Use `None` rather than
omitting a section.

Template revision: 1

## Review Goal

State the Product Owner outcome requested from this review.

## Exact Scope

| Artifact | Revision | Current Maturity Or Status | Requested Action |
|----------|----------|----------------------------|------------------|
| `UC-###` | 1        | draft                      | review           |

## Non-Normative Inputs

List interviews, examples, research, prototype observations, and assumptions. State `None` when no
input applies. Inputs do not become requirements through this packet.

## Normative Delta

Summarize the proposed behavior changes relative to the currently authoritative revisions. Link each
delta to exact artifact revisions and avoid repeating their full normative text.

## Decisions Requested

| Open Question | Revision | Question Status    | Requested Product Owner Action |
|---------------|----------|--------------------|--------------------------------|
| `OQ-###`      | 1        | ready-for-decision | answer                         |

Every listed question must contain reviewed options, consequences, and a recommendation in its own
record. Allowed requested actions are `answer`, `defer`, `supersede`, `reopen`, `resolve`, and
`reduce blocking scope`. Use `None` when no decision is requested.

## Independent Findings

| Finding ID  | Reviewer     | Severity | Finding     | Proposed Disposition | Disposition Owner | Reviewer Concurrence | Rationale | Resolution Reference |
|-------------|--------------|----------|-------------|----------------------|-------------------|----------------------|-----------|----------------------|
| `REQ-F-001` | Requirements | high     | Description | open                 | packet owner      | pending              | Pending   | None                 |

Allowed dispositions are `open`, `resolved`, `deferred`, and `rejected`. Deferred and rejected
findings require explicit non-blocking rationale, Product Owner agreement when they affect the
requested action, and reviewer concurrence. Resolved findings link changed artifact revisions and
re-review evidence. Any continued blocking objection by the originating reviewer keeps this packet
blocked.

## Cross-Cutting Review

| Concern                    | Applicable | Outcome Or Reference |
|----------------------------|------------|----------------------|
| Identity                   | yes/no     | Result               |
| Authorization              | yes/no     | Result               |
| Financial balances         | yes/no     | Result               |
| Audit history              | yes/no     | Result               |
| Privacy                    | yes/no     | Result               |
| Operations and recovery    | yes/no     | Result               |
| Data or contract migration | yes/no     | Result               |
| Future change scenarios    | yes/no     | Result               |

## Readiness Verdict

State exactly one:

- `Ready for Product Owner answers`
- `Ready for specification acceptance`
- `Blocked`

Explain every remaining blocker or state `None`.

A packet ready for Product Owner answers has no acceptance manifest. A packet ready for
specification acceptance has no unanswered decision request. One packet cannot request both actions.

## Acceptance Manifest

List only exact revisions requested for acceptance. Use `None` when the review does not request
acceptance and omit the declaration below in that case.

By merging this pull request, the Product Owner accepts these exact revisions:

- `UC-###` revision 1

All other controlled artifacts in this pull request retain their declared maturity and status.

## Verification Evidence

List requirement validation, link checks, independent re-reviews, examples, and observable evidence.
State checks that remain pending.
