package org.sunflow.core.shader;
public class MirrorShader implements org.sunflow.core.Shader {
    private org.sunflow.image.Color color;
    public MirrorShader() { super();
                            this.color = org.sunflow.image.Color.WHITE; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        color =
          pl.
            getColor(
              "color",
              color);
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        if (!state.
              includeSpecular(
                ))
            return org.sunflow.image.Color.
                     BLACK;
        state.
          faceforward(
            );
        float cos =
          state.
          getCosND(
            );
        float dn =
          2 *
          cos;
        org.sunflow.math.Vector3 refDir =
          new org.sunflow.math.Vector3(
          );
        refDir.
          x =
          dn *
            state.
              getNormal(
                ).
              x +
            state.
              getRay(
                ).
              getDirection(
                ).
              x;
        refDir.
          y =
          dn *
            state.
              getNormal(
                ).
              y +
            state.
              getRay(
                ).
              getDirection(
                ).
              y;
        refDir.
          z =
          dn *
            state.
              getNormal(
                ).
              z +
            state.
              getRay(
                ).
              getDirection(
                ).
              z;
        org.sunflow.core.Ray refRay =
          new org.sunflow.core.Ray(
          state.
            getPoint(
              ),
          refDir);
        cos =
          1 -
            cos;
        float cos2 =
          cos *
          cos;
        float cos5 =
          cos2 *
          cos2 *
          cos;
        org.sunflow.image.Color ret =
          org.sunflow.image.Color.
          white(
            );
        ret.
          sub(
            color);
        ret.
          mul(
            cos5);
        ret.
          add(
            color);
        return ret.
          mul(
            state.
              traceReflection(
                refRay,
                0));
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        float avg =
          color.
          getAverage(
            );
        double rnd =
          state.
          getRandom(
            0,
            0,
            1);
        if (rnd >=
              avg)
            return;
        state.
          faceforward(
            );
        float cos =
          state.
          getCosND(
            );
        power.
          mul(
            color).
          mul(
            1.0F /
              avg);
        float dn =
          2 *
          cos;
        org.sunflow.math.Vector3 dir =
          new org.sunflow.math.Vector3(
          );
        dir.
          x =
          dn *
            state.
              getNormal(
                ).
              x +
            state.
              getRay(
                ).
              getDirection(
                ).
              x;
        dir.
          y =
          dn *
            state.
              getNormal(
                ).
              y +
            state.
              getRay(
                ).
              getDirection(
                ).
              y;
        dir.
          z =
          dn *
            state.
              getNormal(
                ).
              z +
            state.
              getRay(
                ).
              getDirection(
                ).
              z;
        state.
          traceReflectionPhoton(
            new org.sunflow.core.Ray(
              state.
                getPoint(
                  ),
              dir),
            power);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "yBgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6e+zsWFm9v/vavfu4d+/C7rLumwuyW/x1Zjqvujy2M9NO" +
       "Z9pOO51HZ6pw6XOmM31NH9NOceWRIETiSmBBjLAhBqLiwhIiamLQNUaBQEww" +
       "xFciEGMiiiTsH6JxVTzt/N733sUNOklPT8/5zne+7zvf953vfGee/R50NvAh" +
       "2HOtzcxyw109CXcXVmU33Hh6sNtlKrzsB7rWtOQgGIK2q+ojn7v4gxc/ML+0" +
       "A52ToDtlx3FDOTRdJxD0wLXWusZAFw9bCUu3gxC6xCzktYxEoWkhjBmEjzPQ" +
       "LUeGhtAVZp8EBJCAABKQnAQEP4QCg27TnchuZiNkJwxW0M9DpxjonKdm5IXQ" +
       "w8eReLIv23to+JwDgOGm7HsMmMoHJz700AHvW56vYfjDMPL0r7z10udPQxcl" +
       "6KLpDDJyVEBECCaRoFtt3VZ0P8A1Tdck6A5H17WB7puyZaY53RJ0OTBnjhxG" +
       "vn4gpKwx8nQ/n/NQcreqGW9+pIauf8CeYeqWtv911rDkGeD1rkNetxySWTtg" +
       "8IIJCPMNWdX3h5xZmo4WQg+eHHHA4xUaAICh5209nLsHU51xZNAAXd6unSU7" +
       "M2QQ+qYzA6Bn3QjMEkL33hBpJmtPVpfyTL8aQvechOO3XQDq5lwQ2ZAQeuVJ" +
       "sBwTWKV7T6zSkfX5Xu8NT73doZydnGZNV62M/pvAoAdODBJ0Q/d1R9W3A299" +
       "jPmIfNcX37cDQQD4lSeAtzC/93MvPPH6B57/8hbmJ64DwykLXQ2vqp9Ubv/6" +
       "fc1HsdMZGTd5bmBmi3+M81z9+b2exxMPWN5dBxizzt39zueFP5u+89P6d3eg" +
       "Cx3onOpakQ306A7VtT3T0v227ui+HOpaB7pZd7Rm3t+BzoM6Yzr6tpUzjEAP" +
       "O9AZK2865+bfQEQGQJGJ6Dyom47h7tc9OZzn9cSDIOg8eCAYPLdA21/+DqGr" +
       "yNy1dURWZcd0XIT33Yz/bEEdTUZCPQB1DfR6LhJEjmG5MRL4KuL6s4Nv1fV1" +
       "JJjLmu4jrOn7rj/IP3YzRfP+/6dIMi4vxadOgQW476T5W8ByKNcCsFfVp6MG" +
       "8cJnr35158Ac9uQDHBaYbXdvtt1stt3tbLtHZ4NOnconeUU263aFwfosgaUD" +
       "H3jro4O3dN/2vkdOA9Xy4jNAuBkocmNX3Dz0DZ3cA6pAQaHnPxq/a/yOwg60" +
       "c9ynZpSCpgvZcD7zhAce78pJW7oe3ovv/c4PnvvIk+6hVR1z0nvGfu3IzFgf" +
       "OSlT31V1Dbi/Q/SPPSR/4eoXn7yyA50BHgB4vVAGWgocygMn5zhmtI/vO8CM" +
       "l7OAYcP1bdnKuva91oVw7rvxYUu+2Lfn9Tv2tfhu8Ny+p9b5O+u908vKV2yV" +
       "I1u0E1zkDvaNA+/jf/3n/4Tm4t73xReP7G4DPXz8iP1nyC7mln7HoQ4MfV0H" +
       "cH/3Uf5DH/7ee38mVwAA8errTXglK5vA7sESAjG/58urv/nWNz/5jZ1DpQnB" +
       "BhgplqkmB0xm7dCFl2ASzPbaQ3qA/7CAgWVac2Xk2K5mGqasWHqmpf958TXF" +
       "L/zLU5e2emCBln01ev2PRnDY/qoG9M6vvvXfHsjRnFKz/etQZodgW6d45yFm" +
       "3PflTUZH8q6/uP9XvyR/HLhX4NICM9VzLwXlMoDyRUNy/h/Ly90TfcWseDA4" +
       "qvzH7etInHFV/cA3vn/b+Pt/+EJO7fFA5ehas7L3+Fa9suKhBKC/+6SlU3Iw" +
       "B3Dl53s/e8l6/kWAUQIYVbA7B5wPXERyTDP2oM+e/9s//pO73vb109AOCV2w" +
       "XFkj5dzIoJuBduvBHPinxHvzE9vFjW8CxaWcVega5rdKcU/+dQYQ+OiN/QuZ" +
       "xRmHJnrPf3CW8u6///drhJB7lutsryfGS8izH7u3+abv5uMPTTwb/UByreMF" +
       "Mdnh2NKn7X/deeTcn+5A5yXokroX8I1lK8oMRwJBTrAfBYKg8Fj/8YBluzs/" +
       "fuDC7jvpXo5Me9K5HDp8UM+gs/qFE/7k1kzK9+xX9t9H/ckpKK+8OR/ycF5e" +
       "yYqf3Dff855vrsFuvme/PwS/U+D57+zJkGUN2733cnMvAHjoIALwwF50FgQI" +
       "e/HiK0Po7qM7k2mDICuzT9ff+rWsLGXFE9vpKjfUop/OilZyClB4trRb2y1k" +
       "3/T1uTidVV8HPFGQB8dghGE6spXLqgVIWljqlX3axyBYBmp0ZWHV9km+lFtA" +
       "tmC72wjzBK2t/zWtQMNvP0TGuCBYff8/fOBrv/zqbwE17EJn15mKAO07MmMv" +
       "yuL3X3j2w/ff8vS33587VrAs/IvpH70uwzp+KY6zgssKfp/VezNWB27kqzoj" +
       "ByGb+0Jdy7l9SevjfdMGW8Z6LzhFnrz8reXHvvOZbeB50tROAOvve/oXf7j7" +
       "1NM7R8L9V18TcR8dsw35c6Jv25OwDz38UrPkI8h/fO7JP/jNJ9+7pery8eCV" +
       "AGezz/zlf31t96Pf/sp1IqYzlvtjLGx42yeoctDB93/MeNosJ6NxsoRZJIRj" +
       "pjKzYLW5KdCbGcUrhaUhC4N5IE6kRPPs2OLmg7ZaUzmll5bVKmaha77GliN/" +
       "SQ/J0CMEPBgNlcBuWF1ablJtYc4rDZsrKGOvB4cNeSEXZAIjaaax8mnRx9LU" +
       "QfkhrxAcu8SwOK0gqVNXYBhBkHUiRu5m0RW6GOkuiLKcdLywKM6adiJ1saoz" +
       "DRylIZJdeI0ziKIj47ISLVaUO0rVoikXFm0ysiZmd1USQnIgKKxbtAWzJXAD" +
       "yQwGXb/d4aZVz7WjhcxUzJY+ZccSMeZWA6c54KcLtVCWg/bIXrqrYd2erfsk" +
       "OYB7MVF2DKHnqk5U7bkFSeptplh9NoLri5rRonlWFzWJbE0oDO4lDCd67tJL" +
       "EpnGGgIX9iZCUV2mY3kaj+T2BtFdNZxFaMKVPaJAiZWqyirdGtOb4EIo9nqF" +
       "TWin2rzLjOtal3Or8rrXDunAkhoYMRmNRmrPMDu0vuK4skar9IyYp8BYLCGG" +
       "U4vYwEZVY8ucNpFXPVsodaae2GiB0KZjpdhi2jVsY+pKirzmeTLmihuruG5I" +
       "QpvxMInuJohRQtKwGfYLpueOlKmgCWWJGbXmSxIXaNW0TNFbD2WpowuDgkxT" +
       "EWHjnmgNLKVQLYnsSprbM6PIlbrzGWq3bD5hh0V5JsCtXsqGo14RLbHhZlaj" +
       "sHFbEHkcnEWoFdyM0XKpNUtFGsUTtsw3alFsWX11xIxQIVjjtFU3ojTGGwyN" +
       "dgnJH6Myu+r149aKFKdmZ1VkxSUxJOoKjnVWVD/te+25UBqVJB8vBFS9seiy" +
       "y4BdDiYE2cPHqkrGktTvtTA2cdQmMyjQsmo7TmndapfLRmEmF+iOjztajxiH" +
       "DtYuNQSptBCGXmfenREIgQdKsS7wZWQ6WSxHAh4xlY7YbdSxwnrCYOhE18dW" +
       "POmV550CV2Rq5mgzrIfOCO3pE4yfqBO1HY3EtWsF9IiCm6pedJpOtAzbHTyu" +
       "6VVOaTH2kKxJsM7zlFLBURc24SU5YvRwxc+0UrHJ+NyoJ5iK3ZPZIWHRfWok" +
       "oELBKdaNeWvcb8GRTAzYWjBfMkSHGskTel71isgcI6wOEdqdxcqVMbetoV67" +
       "Mrd1BZt1OsKqTJB+WbTwcmAYZFO0/G55QXhy4tlm1Wo1iskCG666SpswRyLW" +
       "Y2MZNgeWpm5Wi/JclKdBVZencBERh4OuJEqx7S0GS5uWosUaR1hRcpM1gpg4" +
       "swjsgknMCJLB7do6Xulsten3u9FoCMuowqCwwnfH07HPUmJawduthjykamFj" +
       "VmMGEmciFt+vEB2+1Ne54tht80KKt2LNZeREgodpCVG1atXFC2nHppft8oLp" +
       "+wTFVPnWPGZbsYegk5qCqfywh6TSXCDxITkgqE69QiJRHy2LwTLRuvYSRLId" +
       "ISbIxmqY2lYtbkVO1y4Hiwgsb7MGNynVl+akjPfFSmWGc7FeEIql8pip9eYl" +
       "DI7aVgHjqpX6plHimkRI0+NWk6vGK5dlK/CouEmpdDM2bK7KuUsXp2YNxQyI" +
       "Cs6q1bikEgHNTOIx2h5sCrHTo3oUqUgWzonYUPCrc15vMnpChlWjks75Rpqk" +
       "ioiYSqooit8s9bHZMqiM+mSSTvi0aPK8zThIJeEFHSViWjYYsjbvNXQK3sTp" +
       "2K3EjFD2fIPp4kPXcAp2XTM9uWCgKhO0TGDWrSixFQHBW/Ksn/BpfxMbhq4j" +
       "WlDCSH4cWQRlpPRobjTN6lBppOO03lk6jCJHMYJbMw9O5Y0No+WeTzJdumVa" +
       "RDRVkZIHDvZhaqQ1neESfC5Q1KInAV+q6DDbCat809cRRNgoenfTTAJ9waQb" +
       "IOoQXdaUVOrxrAOUZbFJQnq9Lg+MBtmnuow4olWmQUwIqUNXC6XUQQgbmcxh" +
       "JZKIEloZGrBLIZWCFy0Njg5bsBIgUYusIptSbKQdHw7mCt+n6yWmt5p1AzQh" +
       "2jZOBtKUijBz3WqlA39cquGLFRe7cdKdKZNWo91fNZppy1tVV7A+4o3QhGvI" +
       "iCa5IoXJK66AlKZcYq9wOLDHc2kWiI0gslRXq3ZE21Y42vRMJ7BSUbR6ilqQ" +
       "LDYsVZ1AQzEnLrKbGkqbBDkoltRJo4vjWmUYlSr16QitIb40KtYxftA21SVW" +
       "qeGrUERaQmsxKZY5BBYHwmxhuRbrKn3YorzynGPghQynmFars6Tob+JRknRw" +
       "sY2EiqBtjDJWGht117S99kjpBZVasxZInjNcLGldWltdRu5XYsWepfZ00JpX" +
       "J5O5SrjTCK2R8zLfNdt8X+rpa74pkuMOxs/wlbFY88UpOWrXg3JhLaqoQoVy" +
       "oFab82SBj1dUr9NsBLIU2iPX9DsqvCloMUlSRhlfwf3ZuCSIXjdodotWjSwF" +
       "7aRBoRZQH1YR5Z64Vk2kYWhDc12fciM0aTCTqUTpCTWz9XrISLpc94fVWod1" +
       "JKxTS8PCasiMijZXCeeib9sSgsC1ydTW4PrIZKgVzVXrA3u8aPBjrarSmj3E" +
       "ualULkYVSVyjrbA2JOUBOXQacDwZ+oyEN/yNEwpwpzmh1unQtQpAkcKos56t" +
       "m/HSW3OTYT/RjJIigdPTakQmtWbQCWgraproCq8UKwFBm0k4rjfdqLgphikR" +
       "MuWBUxxLNRle4hO2a6JMQ1RA8IETg4oDCKxN+mKpX560plTVlNuzPqZE3SQQ" +
       "avVStz8ph+wy6nBqUzaEZq9emMp8szrt+x2+ueErFi52XWB5abulMk4xGsCb" +
       "4QIdOYYJB6rd7jam3QhxHG9TWxvoui4X0X7IbsaT9aKcluwNB0tABUzgR2Fi" +
       "MtNVpNZuo1KfM+ftRRjA0bQilufTZMFaotSoz/FWwRn6eqzrEb9ip02cLW1I" +
       "U43SpZsg1MKrjxhTXpWlMdmQLWQhm53GMArKiqawWuAZxAShNpWegSB1rNd2" +
       "fWnN43Pa1siCJVK9IomSLZTZzErsWKuh0bJqLIe+MMGWNMG54aruzVN2WScL" +
       "hZ7g+1RKe7G+nvFTFq2Vi8vUIpdDsU2N6xWJ60odhi0vGa4xnKRlXFMXYrgY" +
       "EWZ/I0aDulKvShuz0LMn7rLJCswgphPXLSV+ShMUsu4zbG3TbAfcCOvHQjTn" +
       "RE7HyyBccAY8EqBCud9bdob1xGYnSlowbTRsDUcBU+fVFBDiIr2OSw79lsUV" +
       "hIRJ5v0Z3aXGqymqejbq1VpjbqSLZX/Vx6JJalWi8cClF8IkrqYe1WgUdLVU" +
       "n1odAxwLVoq0qKyrqC46tgEMttFbdCvkZOzUjDIciu3BsENL1USQWkTbQEvp" +
       "mJ2JjaE78/RFPKjXO7CNCcXGxm7EILavIAFFmtyiHG+GcB/jMbJimivcpESj" +
       "N9/UFF2usOzamJpdhC4IdVZAK2uKh7t1R5ronTUqzPV6BGutVWuZCAbvUYkn" +
       "rdexq4eoM+cst5qaq4FdGsQ8btJzExVMzI2SKLVqYzwtoBWrGonwZCaWo3LQ" +
       "NjgTLYnhzFGLNr6aJIPVqppEYS2pVuBNm0Sxjc+7vT43xehOx5PDcOhwS3HR" +
       "2ix5am0mE7wL94M1THm19aJdUceozdQQ0+v3Vyuz1cQIu1Jb8YvRJgoGzQ1d" +
       "nUkCOcJR2sBHCFPpKgNdSOoFHANHW4xJbWMua2CXGAYwPJs0VyWW08suvEnx" +
       "wlhLjLYFkyxbJGfDpJc2NV9P+G5LAFFbi69HFmeK6hgfDkxbqG9aTTWmVtIA" +
       "K8QRz2JpxWsh8VjqIpSxaczAgeyNb8yOarOXd1q+I08MHNxDgUNy1iG8jFPi" +
       "tuvhrHjNQVIm/507eXdxNP95mBQ7dd28SZ7R3ybxs5Px/Te6fspPxZ9899PP" +
       "aNynijt7yUYlhG4OXe+nLH2tW0emOg0wPXbjDACb374dJsG+9O5/vnf4pvnb" +
       "XkZq/8ETdJ5E+Vvss19pv1b94A50+iAlds294PFBjx9PhF3w9TDyneGxdNj9" +
       "B5K/MxP0q8BzeU/yl6+fXr9+LizXkq1unMjl7uQAO/tr9cA1a5XLQQ91P0sW" +
       "74PddRRssH3jfCef4R0vkS1+T1akIXQu8jQ53F4kvOWIJsohdF5xXUuXnUMt" +
       "ffuPymUcnSVviA/ElivtfdD2ZgLaf//4Yjt1XMXvv66Km84su9PWcwwffAmx" +
       "fCQrfimEbpnpoQDGZeqRNbUPhfDUjyGE3EjfBJ7dPSHs/p/qTvb5oZzcHOoT" +
       "L8Hor2fFr4XQbYEKHLTu83M33LO7E2pwZu2a2iH7H3s57CchdOvR28Ls6uOe" +
       "a/6NsL1BVz/7zMWb7n5m9Ff5hdnBLffNDHSTEVnW0Uz1kfo5z9cNM2fp5m3e" +
       "2stfz17P223vL7Mcbl7Jyf3tLfxzIXTpJDzgPXsdBfs8UI0jYMBI9mpHgb4Q" +
       "QqcBUFb9Xe86CeBtxj45dcRv7mlKLuHLP0rCB0OOXqhlvjb/O8i+X4y2fwi5" +
       "qj73TLf39heqn9pe6KmWnKYZlpsY6Pz2bvHAtz58Q2z7uM5Rj754++dufs3+" +
       "PnD7luBDrT1C24PXvz0jbC/M77vS37/7d97wG898M89H/w++Tw/lpyMAAA==");
}
