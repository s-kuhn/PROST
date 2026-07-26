---
id: BR-001
title: Consumer Lifecycle
status: draft
source: Product-owner interview on 2026-07-26
---

# BR-001: Consumer Lifecycle

## Rule

A Consumer has exactly one participation state:

| State              | Meaning                                                                                                                                                                      |
|--------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Pending Approval` | The person has authenticated, verified their email, completed the PROST profile, and chosen a unique Tally Name, but an Organization Manager has not approved participation. |
| `Active`           | The Consumer is eligible for inclusion on newly issued Tallies.                                                                                                              |
| `Suspended`        | PROST excluded the Consumer from new Tallies because their balance reached the configured debt threshold.                                                                    |
| `Inactive`         | An Organization Manager or the Consumer ended active participation for a reason independent of automatic debt suspension.                                                    |
| `Pseudonymized`    | Terminal state after an Inactive zero-balance Consumer's login and direct profile identifiers have been irreversibly removed or unlinked.                                    |

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

## Open Questions

- `OQ-012`: How is the first Organization Manager bootstrapped?
- May a Pending Approval registration be rejected and deleted, and after what period?
- How are duplicate local and OIDC identities linked safely?
