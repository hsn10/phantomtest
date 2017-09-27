package dao

import com.outworkers.phantom.macros.DatabaseHelper
import com.outworkers.phantom.dsl._

/** Base class for Phantom database with Play injected Keyspace factory */
abstract class BasePlayDatabase[DB <: BasePlayDatabase[DB]](factory: KeyspaceDefFactory)(implicit helper: DatabaseHelper[DB])
      extends Database[DB](factory.create())(helper)

trait KeyspaceDefFactory {
      /** create key space definition */
      def create() : KeySpaceDef
}
