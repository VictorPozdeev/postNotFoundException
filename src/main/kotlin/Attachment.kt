sealed class Attachment(val type: String)

class AudioAttachment(val audio: Audio) : Attachment("audio")

class Audio(
    var id: Int = 0,
    var ownerId: Int = 0,
    var artist: String = "",
    var title: String = "",
    var duration: Int = 0,
    var url: String = "",
    var lyricsId: Int? = null,
    var albumId: Int? = null,
    var genreId: Int = 0,
    var date: Int = 0,
    var noSearch: Boolean = false,
    var isHq: Boolean = false
)

class DocumentAttachment(val doc: Document) : Attachment("doc")

class Document(
    var id: Int = 0,
    var ownerId: Int = 0,
    var title: String = "",
    var size: Int = 0,
    var ext: String = "",
    var url: String = "",
    var date: Int = 0,
    var typeDocument: Int = 8
)

class PhotoAttachment(val photo: Photo) : Attachment("photo")

class Photo(
    var id: Int = 0,
    var albumId: Int = 0,
    var ownerId: Int = 0,
    var userId: Int = 0,
    var text: String = "",
    var date: Int = 0,
    var size: Array<PhotoSize> = emptyArray<PhotoSize>(),
    var width: Int = 0,
    var height: Int = 0
)

class PhotoSize(
    var type: String = "",
    var url: String = "",
    var width: Int = 0,
    var height: Int = 0
)

class LinkAttachment(val link: Link) : Attachment("link")

class Link(
    var url: String = "",
    var title: String = "",
    var caption: String = "",
    var description: String = "",
    var photo: Photo = Photo(),
    var previewPage: String = "",
    var previewUrl: String = ""
)

class NoteAttachment(val note: Note) : Attachment("note")

class Note(
    var id: Int = 0,
    var ownerId: Int = 0,
    var title: String = "",
    var text: String = "",
    var date: Int = 0,
    var comments: Int = 0,
    var readComments: Int = 0,
    var viewurl: String = ""
)
