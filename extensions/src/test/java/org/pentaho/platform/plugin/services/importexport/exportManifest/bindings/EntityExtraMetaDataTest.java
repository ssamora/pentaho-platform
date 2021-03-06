/*!
 *
 * This program is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
 * Foundation.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 * or from the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 *
 * Copyright (c) 2019 Hitachi Vantara. All rights reserved.
 *
 */

package org.pentaho.platform.plugin.services.importexport.exportManifest.bindings;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSettersExcluding;

public class EntityExtraMetaDataTest {
  @Test
  public void testGettersAndSetters() throws Exception {
    final String[] excludes = new String[] {};
    Assert.assertThat( EntityExtraMetaData.class, hasValidGettersAndSettersExcluding( excludes ) );
  }

  @Test
  public void testMetaData() throws Exception {
    final EntityExtraMetaData entityExtraMetaData = new EntityExtraMetaData();

    Assert.assertTrue( entityExtraMetaData.getMetadata().isEmpty() );

    EntityExtraMetaDataEntry entry = new EntityExtraMetaDataEntry( "key", "value");
    entityExtraMetaData.addMetadata( entry );
    Assert.assertTrue( entityExtraMetaData.getMetadata().size() == 1 );

    Assert.assertEquals( entry, entityExtraMetaData.getMetadata().get( 0 ));

    List<EntityExtraMetaDataEntry> metadata = new ArrayList<>();
    EntityExtraMetaDataEntry entry2 = new EntityExtraMetaDataEntry( "key2", "value2");

    entityExtraMetaData.setMetadata( metadata );
    Assert.assertEquals( metadata, entityExtraMetaData.getMetadata() );

  }
}
