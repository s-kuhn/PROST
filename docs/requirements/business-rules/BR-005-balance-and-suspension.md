---
id: BR-005
title: Balance And Suspension
status: accepted
source: Product-owner interview on 2026-07-26
---

# BR-005: Balance And Suspension

## Balance Rules

1. A Consumer balance is derived from Consumption Charges, Deposits, Refunds, and Adjustments.
2. Amounts use EUR and exact cent precision; binary floating-point arithmetic is not acceptable.
3. A positive balance represents Consumer credit and a negative balance represents Consumer debt.
4. Manual entries require an amount and effective date. Payment method, reference, and free-text
   comment are optional. Actor and audit metadata are automatic.
5. Organization Managers may create or correct entries on their own Consumer account; those actions
   are highlighted in audit views.

## Suspension Rules

1. Automatic debt suspension is either enabled or disabled for the Organization.
2. Automatic debt suspension is disabled by default during initial Organization setup.
3. The maximum-debt amount is initially empty. Enabling automatic debt suspension when no retained
   amount exists requires a nonnegative EUR value with cent precision.
4. When enabled, an Active Consumer becomes Suspended when the balance is negative and the debt
   magnitude is greater than or equal to the configured maximum-debt amount.
5. A maximum debt of EUR 0 suspends a Consumer on the first negative balance; a zero or positive
   balance does not cause suspension.
6. Suspension affects only future Tally issuance and cannot prevent physical consumption on an
   already issued sheet.
7. A Suspended Consumer becomes Active automatically when their balance is zero or positive, or when
   their debt magnitude is less than the configured maximum-debt amount.
8. Disabling automatic debt suspension changes every Suspended Consumer to Active.
9. Balance changes and automatic debt-suspension configuration do not automatically change an
   Inactive Consumer's participation state.
10. Disabling automatic debt suspension retains the last maximum-debt amount without applying it.
    Re-enabling uses the retained amount unless the Organization Manager changes it.
11. Enabling or disabling automatic debt suspension and changing its maximum-debt amount requires a
    preview of all resulting Consumer state transitions.
12. Confirmation is rejected without effect if the suspension configuration or any affected Consumer
    balance or state changed after preview.
13. Successful confirmation atomically persists the suspension configuration, every resulting
    Consumer state transition, and the audit record. If any part fails, none of those changes
    persist.

## Examples

- With a maximum debt of EUR 50, balances from EUR -50.00 downward cause suspension; EUR -49.99 does
  not.
- With a maximum debt of EUR 50, a Suspended Consumer reactivates at EUR -49.99 or above.
- With a maximum debt of EUR 0, EUR -0.01 causes suspension and EUR 0.00 causes reactivation.
- When automatic debt suspension is disabled, no balance causes automatic suspension.

## Future Consideration

A separate warning before automatic suspension is a post-MVP capability and is not part of this
rule.
