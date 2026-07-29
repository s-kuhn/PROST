---
id: BR-001
title: Consumer Lifecycle
status: draft
source: Product-owner interviews on 2026-07-26 and 2026-07-29
---

# BR-001: Consumer Lifecycle

## Rule

A Consumer has exactly one participation state:

| State              | Meaning                                                                                                                                                                                      |
|--------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Pending Approval` | The person has authenticated, verified their email, completed the PROST profile, and chosen a unique Tally Name, but participation has not yet been approved through an authorized workflow. |
| `Active`           | The Consumer is eligible for inclusion on newly issued Tallies.                                                                                                                              |
| `Suspended`        | PROST excluded the Consumer from new Tallies because their balance reached the configured debt threshold.                                                                                    |
| `Inactive`         | An Organization Manager or the Consumer ended active participation for a reason independent of automatic debt suspension.                                                                    |
| `Pseudonymized`    | Terminal state after an Inactive zero-balance Consumer's login and direct profile identifiers have been irreversibly removed or unlinked.                                                    |

## Invariants

1. Tally Name is unique within the Organization and is managed by PROST, not by the identity
   provider.
2. Only Active Consumers appear as regular rows on a newly issued Tally.
3. Pending Approval Consumers appear separately during Settlement so a handwritten blank row can be
   mapped to them.
4. Mapping a Pending Approval Consumer during Settlement approves that Consumer. The resulting
   balance determines whether their next state is Active or Suspended.
5. A Suspended or Inactive Consumer may still be mapped and charged if they used a handwritten row;
   their state does not change as a result.
6. State changes never alter the Consumer rows stored in an already issued Tally Snapshot.
7. Inactive and Suspended Consumers retain authenticated access to their own balance and history.
   Pseudonymized Consumers cannot authenticate.
8. Participation may be made Inactive while the balance is nonzero. Money remains payable or
   refundable.
9. A manually Inactive Consumer cannot be automatically activated by a deposit.
10. Pseudonymization transitions an Inactive Consumer to Pseudonymized and cannot be reversed.
11. [UC-013](../use-cases/UC-013-bootstrap-first-organization-manager.md) is the only
    initial-manager bootstrap path. Its successful confirmation atomically changes the selected
    Consumer from Pending Approval to Active, assigns the Organization Manager role, records the
    Audit Trail, and closes initial-manager bootstrap in the current application state. Restoring an
    older backup reproduces the bootstrap state contained in that backup.

## Open Questions

- May a Pending Approval registration be rejected and deleted, and after what period?
- How are duplicate local and OIDC identities linked safely?
