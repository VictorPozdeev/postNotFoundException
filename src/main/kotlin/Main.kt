fun main() {
    val service = WallService

    service.add(
        Post(
            text = "One post",
            friendsOnly = false,
            likes = Likes(),
            postType = "post",
            canPin = true,
            canDelete = false,
            canEdit = false,
            isPinned = true,
            markedAsAds = true,
            comments = null,
            attachment = arrayOf(
                AudioAttachment(audio = Audio()),
                PhotoAttachment(photo = Photo()),
                NoteAttachment(note = Note())
            )
        )
    )

    service.add(
        Post(
            text = "Two post",
            friendsOnly = true,
            likes = Likes(),
            postType = "copy",
            canPin = true,
            canDelete = false,
            canEdit = false,
            isPinned = true,
            markedAsAds = true,
            comments = Comments(text = "Comment", attachment = null),
            attachment = arrayOf(
                DocumentAttachment(doc = Document()),
                LinkAttachment(link = Link())
            )
        )
    )

    println(service.createComment(1, comments = Comments(text = "Comment", attachment = AudioAttachment(audio = Audio()))))

    println(service.toString())
}

