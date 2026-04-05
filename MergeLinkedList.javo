static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

    SinglyLinkedListNode pointer1 , pointer2 , pointer3;

    if(head1 == null)
        return head2;
    else if(head2 == null)
        return head1;

    // ensure head1 starts with smallest node
    if(head2.data < head1.data){
        SinglyLinkedListNode temp = head1;
        head1 = head2;
        head2 = temp;
    }

    pointer1 = head1;
    pointer2 = head2;
    pointer3 = pointer1;

    while(pointer1 != null && pointer2 != null)
    {
        if(pointer2.data >= pointer1.data)
        {
            pointer3 = pointer1;
            pointer1 = pointer1.next;
        }
        else
        {
            SinglyLinkedListNode temp = pointer2.next;
            pointer3.next = pointer2;
            pointer2.next = pointer1;
            pointer3 = pointer2;
            pointer2 = temp;
        }
    }

    if(pointer2 != null)
        pointer3.next = pointer2;

    return head1;
}
