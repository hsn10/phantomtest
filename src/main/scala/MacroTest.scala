package dao

//import com.outworkers.phantom.database._
import com.outworkers.phantom.dsl._

/** Base class for Phantom database with Play injected Keyspace factory */
abstract class BasePlayDatabase[DB <: BasePlayDatabase[DB]](factory: KeyspaceDefFactory)
      extends Database[DB](factory.create())

trait KeyspaceDefFactory {
      /** create key space definition */
      def create() : KeySpaceDef
}
