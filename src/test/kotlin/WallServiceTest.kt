import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {
    private val newPost1 = Post(
        id = 1,
        text = "The very first post",
        friendsOnly = null,
        comments = null,
        markedAsAds = null,
        attachment = arrayOf(
            AudioAttachment(audio = Audio()),
            PhotoAttachment(photo = Photo()),
            NoteAttachment(note = Note())
        )
    )
    private val newPost2 =
        Post(
            id = 2,
            text = "Second post",
            friendsOnly = false,
            comments = Comments(text = "Comment", attachment = null),
            markedAsAds = true,
            attachment = arrayOf(
                DocumentAttachment(doc = Document()),
                LinkAttachment(link = Link())
            )
        )
    private val newPost2Update =
        Post(
            id = 2,
            text = "Updated second post",
            friendsOnly = true,
            comments = Comments(text = "Comment", attachment = null),
            markedAsAds = false,
            attachment = arrayOf(
                DocumentAttachment(doc = Document()),
                LinkAttachment(link = Link()),
                AudioAttachment(audio = Audio())
            )
        )

    private
    val newPost3 =
        Post(
            id = 3, text = "Third post", friendsOnly = null, comments = null, markedAsAds = null, attachment = arrayOf(
                DocumentAttachment(doc = Document()),
                LinkAttachment(link = Link())
            )
        )

    private
    val newPostWrongId =
        Post(
            id = -100,
            text = "Wrong Id",
            friendsOnly = null,
            comments = null,
            markedAsAds = null,
            attachment = emptyArray()
        )

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addPostToWall() {

        val wall = WallService

        val result = wall.add(newPost1).id

        assertEquals(1, result)
    }

    @Test
    fun updateExisting() {
        val wall = WallService

        wall.add(newPost1)
        wall.add(newPost2)
        wall.add(newPost3)

        val update = newPost2Update

        val result = wall.update(update)

        assertTrue(result)
    }

    @Test
    fun updateExisting_Negative() {
        val wall = WallService

        wall.add(newPost1)
        wall.add(newPost2)
        wall.add(newPost3)

        val update = newPostWrongId

        val result = wall.update(update)

        assertFalse(result)
    }
}